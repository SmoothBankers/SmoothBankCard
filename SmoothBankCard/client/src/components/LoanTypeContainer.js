import React, { useEffect } from 'react';
import PropTypes from 'prop-types';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import * as loanTypeActions from '../actions/loanTypeActions.js';
import LoanTypeRender from './LoanTypeRender';

const LoanTypeContainer = (props) => {

    const { actions } = props; 

    const loanTypes = <LoanTypeRender {...props} />;

    useEffect(() => {
        actions.readLoanTypes();
        // eslint-disable-next-line
    }, [actions.readLoanTypes] );

   /**
    * TODO: Use props.match.params.id to get the proper LoanTypeRenderInfo page
    */
    return(
        <div>
            <div style = {{display:'flex', alignItems:'center', justifyContent:'center'}}>
                {loanTypes}   
            </div>
        </div>
    );
}

function mapStateToProps(state){
    return {
        loanTypeData: state.loanTypeReducer.loanTypeData
    }
}

function mapDispatchToProps(dispatch){
    return { 
        actions: bindActionCreators(loanTypeActions, dispatch)
    }
}

LoanTypeContainer.propTypes = {
    actions: PropTypes.object
};

export default connect( 
    mapStateToProps,
    mapDispatchToProps
    )(LoanTypeContainer);
