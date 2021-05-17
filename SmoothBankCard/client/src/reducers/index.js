import { combineReducers } from 'redux';
import cardTypeReducer from './cardTypeReducer';
import loanTypeReducer from './loanTypeReducer';

const rootReducer = combineReducers({
  cardTypeReducer,
  loanTypeReducer,
});

export default rootReducer;
