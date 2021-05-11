import axios from 'axios'
import { READ_CARD_TYPES_FAILURE, READ_CARD_TYPES_PENDING, READ_CARD_TYPES_SUCCESFUL } from '../constants/actionTypes'

export const readCardTypes = () =>{
    return dispatch => {
        dispatch(_readCardTypesStarted());

        return axios.get('localhost:8080/api/cardTypes')
        .then(res => {
            dispatch(_readCardTypesSuccess(res))
        })
        .catch( (error) => {
            console.log(error);
            dispatch(_readCardTypesFailed(error));
        });
    }
}

const _readCardTypesSuccess = (res) => {
    return {
        type: READ_CARD_TYPES_SUCCESFUL,
        data:  res.data
    };
}

const _readCardTypesFailed = (error) => {
    return {
        type: READ_CARD_TYPES_FAILURE,
        error  
    };
}

const _readCardTypesStarted = () => {
    return {
        type: READ_CARD_TYPES_PENDING
    };
}