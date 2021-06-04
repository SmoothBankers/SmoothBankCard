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
            <h1 style = {{display:'flex', alignItems:'center', justifyContent:'center'}}> About this card</h1>
            <h2 style = {{display:'flex', alignItems:'center', justifyContent:'center'}}> {props.match.params.id} </h2>
            <h2 style = {{display:'flex', alignItems:'center', justifyContent:'center'}}> </h2>
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
