import axios from 'axios';
import {CREATE_CARD_FAILURE, CREATE_CARD_PENDING, CREATE_CARD_SUCCESS  } from '../constants/actionTypes';

export const createCard = (cardTypeId, cardHolderName) =>{
    console.log("Creating card with id " + cardTypeId + " and cardholder name as " + cardHolderName);
    //So the above log is printed, which means that createCard is called with the proper parameters being passed
    return dispatch => {
        //However, the below log is not printed, which means that for whatever reason dispatch here is not being called or something.
        console.log("Creating card...");
        dispatch(_createCardStarted());
        return axios.post(
            'http://localhost:8080/api/cards',
            {
             //until integration with account is done, use this example value. Will have to change or constantly delete the card from the
             //database though, otherwise it (ideally) won't do anything because it would detect the card already exists.
             accountNumber: 875662154897,
             cardType: cardTypeId,
             holderName: cardHolderName
            }
        )
        .then( res => {
            console.log("Axios claims to have added the card");
            dispatch(_createCardSuccess(res));
        })
        .catch((error) => {
            console.log(error);
            dispatch(_createCardFailed(error));
        });
}
}

const _createCardStarted = () => {
    console.log("Called _createCardStarted");
    return {
        type: CREATE_CARD_PENDING
    };
}

const _createCardFailed = () => {
    return {
        type: CREATE_CARD_FAILURE
    };
}

const _createCardSuccess = () =>{
    return {
        type: CREATE_CARD_SUCCESS
    };
}