import React from 'react';

const Home = () => {
    return(
        <div className = "mainMenu">
            <h1> Welcome to SmoothBank! </h1>
            <h3> Look at our offers </h3>
            <li><a href="/cardTypes">View our cards</a></li>
            <li><a href="/loanTypes">View our loans</a></li>
            <li><a href="/cards"> Get a card</a></li>
        </div>
    )
}

export default Home;