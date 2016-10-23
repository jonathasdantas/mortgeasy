import React from 'react';
import { Router, Route, hashHistory, IndexRoute, IndexRedirect } from 'react-router';

import Main from './components/main/main';
import Menu from './components/main/menu';

import Simulator from './components/simulator/simulator';

import MortgageForm from './components/forms/mortgage-form';
import MortgageResult from './components/forms/mortgage-result';

export default (
    <Router history={hashHistory}>
        <Route path="/" component={Main}>
            <Route path="simulator" component={Simulator}>
                <IndexRedirect to="/simulator/mortgage"/>
                <Route path="mortgage" component={MortgageForm}/>
                <Route path="result" component={MortgageResult}/>
            </Route>
        </Route>
    </Router>
    );
