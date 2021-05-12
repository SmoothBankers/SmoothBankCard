import { combineReducers } from 'redux';
import cardTypeReducer from './cardTypeReducer';

const rootReducer = combineReducers({
  cardTypeReducer,
});

export default rootReducer;
