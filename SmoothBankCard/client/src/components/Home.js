import React from 'react';

const Home = () => {
    return(
        <div className = "mainMenu">
            <h1 style = {{display:'flex', alignItems:'center', justifyContent:'center'}}> Welcome to SmoothBank! </h1>
            <h3 style = {{display:'flex', alignItems:'center', justifyContent:'center'}}> Take a look at our offers </h3>
            <li style = {{display:'flex', alignItems:'center', justifyContent:'center'}}><a href="/cardTypes">View our cards</a></li>
            <li style = {{display:'flex', alignItems:'center', justifyContent:'center'}}><a href="/loanTypes">View our loans</a></li>
            <li style = {{display:'flex', alignItems:'center', justifyContent:'center'}}><a href="/cards"> Get a card</a></li>
            <li style = {{display:'flex', alignItems:'center', justifyContent:'center'}}><a href="/loans"> Get a loan</a></li>
        </div>
    )
}

export default Home;