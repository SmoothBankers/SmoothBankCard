import { combineReducers } from 'redux';
import cardTypeReducer from './cardTypeReducer';
import loanTypeReducer from './loanTypeReducer';
import cardReducer from './cardReducer';

const rootReducer = combineReducers({
  cardTypeReducer,
  loanTypeReducer,
  cardReducer,
});

export default rootReducer;
