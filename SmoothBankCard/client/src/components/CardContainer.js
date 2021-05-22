import React from 'react';
import { connect } from 'react-redux';
import * as cardActions from '../actions/cardActions';
import CardTypeContainer from './CardTypeContainer';
import { bindActionCreators } from 'redux';
import PropTypes from 'prop-types';


class CardContainer extends React.Component{

    constructor(props){
        super(props);
        
        this.state = {
            cardType: '',
            holderName: '',
            accountNumber: 0
        };

        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleChange = this.handleChange.bind(this);
        this.nameChange = this.nameChange.bind(this);
        this.afterSubmission = this.afterSubmission.bind(this);
        this.accountChange = this.accountChange.bind(this);
    }

    handleChange(event){
        this.setState({
            cardType: event.target.value,            
            accountNumber: this.state.accountNumber,
            holderName: this.state.holderName
        });
    }

    handleSubmit(event) {
        this.props.actions.createCard(this.state.cardType, this.state.holderName, this.state.accountNumber);
        event.preventDefault();
    }

    afterSubmission(event){
        event.preventDefault();
    }

    nameChange(event){
        this.setState({
            holderName: event.target.value,
            cardType: this.state.cardType,
            accountNumber: this.state.accountNumber
        });
    }
    
    accountChange(event){
        this.setState({
            holderName: this.state.holderName,
            cardType: this.state.cardType,
            accountNumber: event.target.value
        });
    }

    render(){

       //TODO: Get all the CardTypes and put them in a dropdown list

        return(
            <div>
                <CardTypeContainer />
                    <form onSubmit={this.handleSubmit}>
                        <label>
                            CardType:
                            <input type="text" value={this.state.cardType} onChange={this.handleChange} />
                        </label>
                        <br />
                        <label>
                            Holder name:
                            <input type="text" value={this.state.holderName} onChange={this.nameChange}/>
                        </label>
                        <br />
                        <label>
                            Account number:
                            <input type="number" value={this.state.accountNumber} onChange={this.accountChange}/>
                        </label>
                        < br />
                        <input type="submit" value="Register" />
                    </form>
            </div>
        );
    }

} 

function mapStateToProps(state){
    return {
      cardData: state.cardReducer.cardData
    }
}

function mapDispatchToProps(dispatch){
    return { 
        actions: bindActionCreators(cardActions, dispatch)
    }
}

CardContainer.propTypes = {
    actions: PropTypes.object
};

export default connect( 
    mapStateToProps,
    mapDispatchToProps
    )(CardContainer);
