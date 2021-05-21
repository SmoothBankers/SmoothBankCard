import React from 'react';
import { connect } from 'react-redux';
import * as cardActions from '../actions/cardActions';
import CardTypeContainer from './CardTypeContainer';
import { bindActionCreators } from 'redux';


class CardContainer extends React.Component{

    constructor(props){
        super(props);
        
        this.state = {
            cardType: '',
            holderName: ''
        };

        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleChange = this.handleChange.bind(this);
        this.nameChange = this.nameChange.bind(this);
        this.afterSubmission = this.afterSubmission.bind(this);
    }

    handleChange(event){
        this.setState({
            cardType: event.target.value
        });
    }

    handleSubmit(event) {
        cardActions.createCard(this.state.cardType, this.state.holderName); //this is called, but there are problems
        event.preventDefault();
    }

    afterSubmission(event){
        event.preventDefault(); //should stop the page from refreshing
    }

    nameChange(event){
        this.setState({
            holderName: event.target.value
        });
    }

    render(){
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
                        <input type="submit" value="Register" />
                    </form>
            </div>
        );
    }

} 

function mapStateToProps(state){
    console.log("mapStateToProps called");
    return {
      cardData: state.cardReducer.cardData
    }
}

function mapDispatchToProps(dispatch){
    console.log("mapDispatchToProps called");
    return { 
        actions: bindActionCreators(cardActions, dispatch)
    }
}

export default connect( 
    mapStateToProps,
    mapDispatchToProps
    )(CardContainer);
