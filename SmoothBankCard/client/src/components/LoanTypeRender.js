import React from 'react';
import PropTypes from 'prop-types';

const LoanTypeRender = ({ loanTypeData }) => {

    function createLoanTypeRow(loanType){
        return (
            <tr key={loanType.title}>
                <td> <a href = {'/loanTypes/' + loanType.id}> {loanType.title} </a> </td>
                <td> {loanType.description} </td>
                <td> {loanType.rate} </td>
            </tr>
        );
    }

    let content = '';    
 
    if(!loanTypeData || loanTypeData.requestPending){
        content = (
            <div className="d-flex justify-content-center">
                <div className="spinner-border" role="status">
                    <span className="sr-only">Loading...</span>
                </div> 
            </div>
        );
    }
    

    /**
     * TODO: Update this so that the Name is a hyperlink to a page
     * with a more detailed explanation of the loan.
     * 
     * Send a GET request with the loan's id to get the more
     * detailed information? Should work provided that the extra
     * information is also stored in the database, which it should
     * be anyway.
     */
    if(loanTypeData && loanTypeData.requestSuccess){
        const info = loanTypeData.types
        console.log(info);
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
        </div>
    );
}

LoanTypeRender.propTypes = {
    loanTypeData: PropTypes.object
};

export default LoanTypeRender;
