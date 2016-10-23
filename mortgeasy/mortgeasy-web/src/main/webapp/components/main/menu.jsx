import React from 'react';

import { Link } from 'react-router';

import '../../../assets/style/main.scss';

class Menu extends React.Component {
    constructor(...args) {
        super(...args);
        this.state = {};
    }

    render() {
        return (
            <nav>
                <ul>
                    <li><Link to="/simulator">Simulator</Link></li>
                    <li><Link to="/market">Mortgage Market</Link></li>
                </ul>
            </nav>
        );
    }
}

export default Menu;
