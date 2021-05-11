import React from 'react';
import PropTypes from 'prop-types';

const CardTypeRender = ({cardTypeData}) =>{

    function createCardTypeRow(cardType){
        return(
            <tr key={cardType.id}>
                <td> {cardType.id} </td>
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
        content = (
            <table className="cardTypeTable">
                <thread>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Desc.</th>
                    </tr>
                </thread>
                <tbody>
                    {cardTypeData.cardTypes.map((cardType) => createCardTypeRow(cardType))}
                </tbody>
            </table>
        )
    }

    if(cardTypeData && cardTypeData.requestFailed){
        content = (
            <div className="alert alert-danger" role="alert">
                Error loading Card Types!
            </div>
        )
    }

    return(
        <div>
            <h1>Card Types</h1>
            {content}
        </div>
    );
}

CardTypeRender.PropTypes = {
    cardTypeData: PropTypes.object
};

export default CardTypeRender;