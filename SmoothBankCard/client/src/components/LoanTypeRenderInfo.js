import React from 'react';
import { connect } from 'react-redux';
import * as loanActions from '../actions/loanActions';
import { bindActionCreators } from 'redux';
import PropTypes from 'prop-types';


class LoanTypeRenderInfo extends React.Component{

    constructor(props){
        super(props);
        
        this.state = {
            information: 'Test'
        };
    }

    render(){
        return(
           <div> {this.props.data} </div>
        );
    }

} 

function mapStateToProps(state){
    return {
      loanData: state.loanReducer.loanData
    }
}

function mapDispatchToProps(dispatch){
    return { 
        actions: bindActionCreators(loanActions, dispatch)
    }
}

LoanTypeRenderInfo.propTypes = {
    actions: PropTypes.object
};

export default connect( 
    mapStateToProps,
    mapDispatchToProps
    )(LoanTypeRenderInfo);
