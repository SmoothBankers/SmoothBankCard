import './App.css';
import React from 'react';
import { BrowserRouter, Switch, Route} from 'react-router-dom';
import Home from './components/Home.js';
import CardTypeContainer from './components/CardTypeContainer';
import configureStore from './store/configureStore';
import {Provider } from 'react-redux';
import LoanTypeContainer from './components/LoanTypeContainer';
import CardContainer from './components/CardContainer';

function App() {
  return(
    <div>
      <BrowserRouter>
      <Provider store={configureStore()}>
      <Switch>
            <Route exact path='/' component={Home}/>
            <Route path='/cardTypes' component={CardTypeContainer}/>
            <Route path='/loanTypes' component={LoanTypeContainer}/>
            <Route path='/cards' component={CardContainer}/>
        </Switch>
      </Provider>        
      </BrowserRouter>
    </div>
);
}

export default App;
