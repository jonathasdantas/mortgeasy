import React from 'react';

import ResultItem from './result-item';

class ResultList extends React.Component {
    render() {
        let items = [];

        this.props.items.forEach((item, index) => {
            items.push(<ResultItem key={index} label={item.label} value={item.value} />);
        });

        return (
            <div className="result-list">
                {items}
            </div>
        );
    }
}

export default ResultList;