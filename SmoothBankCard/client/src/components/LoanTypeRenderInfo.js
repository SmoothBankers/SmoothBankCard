import React from 'react';
import PropTypes from 'prop-types';

const LoanTypeRender = ({ loanTypeData }) => {

    let info = '';
    if(loanTypeData){
        console.log("Loan Type Data for Information Render");
        console.log(loanTypeData.match);
    }

        return (
            <div> 
                <div> TODO: Replace this with more in-depth information of card# </div>
                {info}
            </div>

        );
}

LoanTypeRender.propTypes = {
    loanTypeData: PropTypes.object
};

export default LoanTypeRender;
