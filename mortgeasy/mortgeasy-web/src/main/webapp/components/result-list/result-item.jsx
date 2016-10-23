import React from 'react';

class ResultItem extends React.Component {
    render() {
        return (
            <div className="result-item">
                <div className="result-item-label">
                    <label>{ this.props.label }</label>
                </div>
                <div className="result-item-value">
                    <span>{ this.props.value }</span>
                </div>
            </div>
        );
    }
}

export default ResultItem;
