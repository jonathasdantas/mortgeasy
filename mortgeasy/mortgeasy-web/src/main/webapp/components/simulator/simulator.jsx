import React from 'react';
import '../../../assets/style/main.scss';

import MortgageForm from '../forms/mortgage-form';

class Simulator extends React.Component {
    constructor(...args) {
        super(...args);
        this.state = {};
    }

    render() {
        return (
            <article>
                { this.props.children }
            </article>
        );
    }
}

export default Simulator;
