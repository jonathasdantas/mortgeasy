import React from 'react';

import '../../../assets/style/main.scss';
import Menu from './menu';

class Main extends React.Component {
    constructor(...args) {
        super(...args);
        this.state = {};
    }

    render() {
        return (
            <section className="main-container">
                <header>
                    MortgEasy
                </header>
                { this.props.children || <Menu /> }
            </section>
        );
    }
}

export default Main;
