import React from 'react';

import store from '../../store';
import { addUserToMortgageProposal } from '../../actions/mortgage-form-actions';

import '../../../assets/style/main.scss';

import { Jumbotron, Button, ButtonToolbar } from 'react-bootstrap';

import FacebookLogin from 'react-facebook-login';

import ResultList from '../result-list/result-list';

class MortgageResult extends React.Component {
    constructor(...args) {
        super(...args);

        this.currentState = store.getState('mortgageFormState').mortgageFormState;
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleBack = this.handleBack.bind(this);
    }

    // Map to an Item with a Label and a Value
    getItems() {
        let items = [];
        Object.keys(this.currentState).forEach((key) => {
            items.push({ label: this.currentState[key].label, value: this.currentState[key].value });
        });

        return items;
    }

    getMoreInfoItems() {
        let items = [];

        if (this.currentState.purchasePrice.value) {
            items.push({ label: 'Total Mortgage', value: (this.currentState.purchasePrice.value - this.currentState.downPayment.value) });
            items.push({ label: 'Amortization Period', value: 25 });
            items.push({ label: 'Interest Rate', value: '6.43% - 12.7%' });
        }
        

        return items;

    }

    responseFacebook(response) {
        console.log(response);
        store.dispatch(addUserToMortgageProposal({
            name: response.name,
            userId: response.id,
        }));

        console.log(store.getState('mortgageFormState').mortgageFormState);

        if (this.props) {
            this.props.router.push('/simulator/result');  
        }
    }

    handleSubmit() {
        // API Call to Add Proposal to the DB
        this.context.router.push('/simulator/result');
    }

    handleBack() {
        this.context.router.push('/simulator/mortgage');
    }

    render() {
        return (
            <div>
                <Jumbotron className="payment-value">
                    <h1>$ 1,568.22</h1>
                    <p>Monthly Payment</p>
                </Jumbotron>
                <ResultList items={this.getItems()} />
                <div className="more-info-result">
                    <filedset >
                        <legend>More Information</legend>
                        <ResultList items={this.getMoreInfoItems()} />
                    </filedset>
                    <ButtonToolbar>
                        <Button type="button" onClick={(e) => this.handleBack(e)}>Back</Button>
                        <Button type="button" bsStyle="success" onClick={(e) => this.handleSubmit(e)}>Make an Offer</Button>
                        <FacebookLogin
                          appId="346869785647646"
                          autoLoad={true}
                          fields="name,email,picture"
                          scope="public_profile,user_friends,user_actions.books"
                          callback={this.responseFacebook}
                          textButton="Offer with Facebook"
                          cssClass="facebookIcon"
                          icon="fa-facebook"
                        />
                    </ButtonToolbar>

                </div>
            </div>
        );
    }
}

MortgageResult.contextTypes = { 
    router: React.PropTypes.object.isRequired
};

export default MortgageResult;
