import React from 'react';

import store from '../../store';
import { setMortgageInitialData } from '../../actions/mortgage-form-actions';

import '../../../assets/style/main.scss';

import { FormGroup, ControlLabel, FormControl, Button } from 'react-bootstrap';

class MortgageForm extends React.Component {
    constructor(...args) {
        super(...args);

        this.handleChange = this.handleChange.bind(this);
    }

    /* Handles Functions */
    handleChange(event) {
        store.dispatch(setMortgageInitialData({
            [event.target.name]: {
                label: event.target.dataset.label,
                value: event.target.value,
            },
        }));
    }

    handleSubmit() {
        this.context.router.push('/simulator/result');
    }

    render() {
        return (
            <form className="mortgage-form">
                <FormGroup bsSize="large" controlId="my-goal">
                    <ControlLabel>My Goal</ControlLabel>
                    <FormControl
                      componentClass="select"
                      defaultValue="{this.state.goal}"
                      name="myGoal"
                      onChange={this.handleChange}
                      data-label="My Goal"
                    >
                        <option value="">Choose your Goal...</option>
                        <option value="new">Buy my first new home</option>
                    </FormControl>
                </FormGroup>
                <FormGroup bsSize="large" controlId="purchase-price">
                    <ControlLabel>Purchase Price</ControlLabel>
                    <FormControl
                      type="text"
                      onChange={this.handleChange}
                      name="purchasePrice"
                      className="form-control"
                      placeholder="Enter your Purchase Price"
                      data-label="Purchase Price"
                    />
                </FormGroup>
                <FormGroup bsSize="large" controlId="down-payment">
                    <ControlLabel>Down Payment</ControlLabel>
                    <FormControl
                      type="text"
                      onChange={this.handleChange}
                      name="downPayment"
                      className="form-control"
                      placeholder="Enter your Down Payment"
                      data-label="Down Payment"
                    />
                </FormGroup>
                <Button onClick={(e) => this.handleSubmit(e)} type="button">Next</Button>
            </form>
        );
    }
}

MortgageForm.contextTypes = { 
    router: React.PropTypes.object.isRequired
};

export default MortgageForm;
