import React from 'react';
import {Switch, Route} from 'react-router-dom';
import Header from './Header.js';
import Home from './Home.js';
import CardTypeContainer from './CardTypeContainer.js';

export class App extends React.Component{
    render(){
        return(
            <div>
                <Header />
                <Switch>
                    <Route exact path='/' component={Home}/>
                    <Route path='/cards' component={CardTypeContainer}/>
                </Switch>
            </div>
        );
    }
}