import React, { useState } from 'react';
import PropTypes from 'prop-types';
import LoanTypeRenderInfo from './LoanTypeRenderInfo';

const LoanTypeRender = ({ loanTypeData }) => {
    let content = '';
    const [displayComp, setDisplayComp] = useState('');

    function createLoanTypeRow(loanType){
        return (
             <tr key = {loanType.id}>
                <td>
               <button
                onClick={ () => {
                    setDisplayComp(<LoanTypeRenderInfo data={loanType.description}/>)         
                   } }>
                   {loanType.title}
               </button>
               </td>
               <td> {loanType.description} </td>
               <td> {loanType.rate} </td>
            </tr>
        );
    }  
    if(!loanTypeData || loanTypeData.requestPending){
        content = (
            <div className="d-flex justify-content-center">
                <div className="spinner-border" role="status">
                    <span className="sr-only">Loading...</span>
                </div> 
            </div>
        );
    }
    
    if(loanTypeData && loanTypeData.requestSuccess){
        const info = loanTypeData.types
        //console.log(info);
        content = 
            (
            <div>
                <table className="table">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Interest</th>
                        </tr>
                    </thead>
                    <tbody>
                        { info.map(type => ( createLoanTypeRow(type) ) ) }
                    </tbody>    
                </table> 
                <a href="/">Home</a> 
            </div>
            );
    }

    if(loanTypeData && loanTypeData.requestFailed){
        content = 
        (
            <div className="alert alert-danger" role="alert">
                Error while loading card types!
            </div>
        )
    }
        
    return(
        <div>
            <h1 style = {{display:'flex', alignItems:'center', justifyContent:'center'}}>Here are our different types of loans</h1>
            {content}
            <h1 style = {{display:'flex', alignItems:'center', justifyContent:'center'}}> About this loan </h1>
            {displayComp}
        </div>
    );
}

LoanTypeRender.propTypes = {
    loanTypeData: PropTypes.object
};

export default LoanTypeRender;