import { READ_CARD_TYPES_SUCCESFUL, READ_CARD_TYPES_PENDING, READ_CARD_TYPES_FAILURE } from '../constants/actionTypes';

export default function bookReducer(state = {}, action) {
  switch (action.type) {
    case READ_CARD_TYPES_SUCCESFUL:
      return {...state, cardTypeData: { cardTypes: action.data, requestSucessful: true } };
    case READ_CARD_TYPES_PENDING:
      return {...state, cardTypeData: {requestPending: true } };
    case READ_CARD_TYPES_FAILURE:  
      return {...state, cardTypeData: { requestFailed: true } };
    default:
      return state;
  }
}
