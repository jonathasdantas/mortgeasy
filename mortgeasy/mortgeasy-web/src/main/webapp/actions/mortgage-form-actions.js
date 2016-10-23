import * as types from './action-types';

export function setMortgageInitialData(formData) {
    return {
        type: types.SET_MORTGAGE_INITIAL_DATA,
        formData,
    };
}

export function addMortgageProposal(formData) {
    return {
        type: types.ADD_MORTGAGE_PROPOSAL,
        formData,
    };
}

export function addUserToMortgageProposal(formData) {
    return {
        type: types.ADD_USER_TO_MORTGAGE_PROPOSAL,
        formData,
    };
}
