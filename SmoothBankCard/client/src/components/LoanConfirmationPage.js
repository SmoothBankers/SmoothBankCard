//Simple page, should just send the confirmation request to the back end and inform the user of the status
import React, {Component} from 'react';
import axios from 'axios';

class LoanConfirmationPage extends Component{

    async handleConfirm(token){
        try{
            //send get request with token
            const {data} = await axios.put('http://localhost:8081/api/loans', token);
            return data;
        } catch(ex){
            //some error
        }
    }

    render() {
        //obtain token from URL params
        const search = this.props.location.search;
        const token =  new URLSearchParams(search).get('token');
        
        //submit http get with token as header
        const res = this.handleConfirm(token);
        //await response

        //return message depending on response

        return (
            <div>
                <h1>Token is {token}</h1>
            </div>
        );
    }

}

export default LoanConfirmationPage;