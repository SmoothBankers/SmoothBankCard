import axios from 'axios';
import {CREATE_CARD_FAILURE, CREATE_CARD_PENDING, CREATE_CARD_SUCCESS  } from '../constants/actionTypes';

export const createCard = (cardTypeId, cardHolderName, accountNum) =>{
    return dispatch => {
        console.log(cardTypeId, cardHolderName, accountNum);
        dispatch(_createCardStarted());
        /**
         * Okay, so we have a very interesting conundrum. The data is being partially sent. The API gets the
         * holder name and nothing else. The Controller is never called for some reason, the post is sent
         * directly to the database or something because even with the controller completely empty the
         * 8080 server receives and stores a card object that only has the holderName. I have no idea
         * what is causing this behavior.
         */
        return axios.post(
            'http://localhost:8080/api/cards/',
            {
             //until integration with account is done, use this example value. Will have to change or constantly delete the card from the
             //database though, otherwise it (ideally) won't do anything because it would detect the card already exists.
             accountNumber: accountNum,
             cardType: cardTypeId,
             holderName: cardHolderName
            }
        )
        .then( (res) => {
            dispatch(_createCardSuccess(res));
        })
        .catch((error) => {
            console.log(error);
            dispatch(_createCardFailed(error));
        });
}
}

const _createCardStarted = () => {
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