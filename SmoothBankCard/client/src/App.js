import './App.css';
import React from 'react';
import { BrowserRouter, Switch, Route} from 'react-router-dom';
import Home from './components/Home.js';
import CardTypeContainer from './components/CardTypeContainer'
import configureStore from './store/configureStore';
import {Provider } from 'react-redux';

function App() {
  return(
    <div>
      <BrowserRouter>
      <Provider store={configureStore()}>
      <Switch>
            <Route exact path='/' component={Home}/>
            <Route path='/cardTypes' component={CardTypeContainer}/>
        </Switch>
      </Provider>        
      </BrowserRouter>
    </div>
);
}

export default App;
