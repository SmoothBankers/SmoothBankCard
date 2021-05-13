import React from 'react';
import PropTypes from 'prop-types';

const CardTypeRender = ({ cardTypeData }) => {

    function createCardTypeRow(cardType){
        return (
            <tr key={cardType.title}>
                <td> {cardType.title} </td>
                <td> {cardType.description} </td>
            </tr>
        );
    }

    let content = '';    
 
    if(!cardTypeData || cardTypeData.requestPending){
        content = (
            <div className="d-flex justify-content-center">
                <div className="spinner-border" role="status">
                    <span className="sr-only">Loading...</span>
                </div> 
            </div>
        );
    }
    

    if(cardTypeData && cardTypeData.requestSuccessful){
        const info = cardTypeData.types._embedded.cardTypes;
        console.log(info);
        content = 
            (
            <div>
                <table className="table">
                    <thead>
                        <tr>
                            <th>Title</th>
                            <th>Author</th>
                        </tr>
                    </thead>
                    <tbody>
                        { info.map(type => ( createCardTypeRow(type) ) ) }
                    </tbody>    
                </table>  
            </div>
            );
    }

    if(cardTypeData && cardTypeData.requestFailed){
        content = 
        (
            <div className="alert alert-danger" role="alert">
                Error while loading card types!
            </div>
        )
    }
        
    return(
        <div>
            <h1>Card Types</h1>
            {content}
            <h1> This goes after content </h1>
        </div>
    );
}

CardTypeRender.propTypes = {
    cardTypeData: PropTypes.object
};

export default CardTypeRender;
