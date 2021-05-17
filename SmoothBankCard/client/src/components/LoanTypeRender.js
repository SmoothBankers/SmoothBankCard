import React from 'react';
import PropTypes from 'prop-types';

const LoanTypeRender = ({ loanTypeData }) => {

    function createLoanTypeRow(loanType){
        return (
            <tr key={loanType.title}>
                <td> {loanType.title} </td>
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
    

    if(loanTypeData && loanTypeData.requestSuccess){
        const info = loanTypeData.types._embedded.loanTypes;
        console.log(info);
        content = 
            (
            <div>
                <table className="table">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Description</th>
                            <th> Interest </th>
                        </tr>
                    </thead>
                    <tbody>
                        { info.map(type => ( createLoanTypeRow(type) ) ) }
                    </tbody>    
                </table>  
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
            <h1>Loan Types</h1>
            {content}
        </div>
    );
}

LoanTypeRender.propTypes = {
    loanTypeData: PropTypes.object
};

export default LoanTypeRender;
