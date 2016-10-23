import * as types from '../actions/action-types.js';

const initialState = {
    myGoal: '',
    purchasePrice: '',
    downPayment: '',
};

const mortgageFormReducer = function mortgageFormReducer(state = initialState, action) {
    let propChanged;

    if (action && action.formData) {
        if (action.formData.myGoal) {
            propChanged = { myGoal: action.formData.myGoal };
        } else if (action.formData.purchasePrice) {
            propChanged = { purchasePrice: action.formData.purchasePrice };
        } else if (action.formData.downPayment) {
            propChanged = { downPayment: action.formData.downPayment };
        } else {
            propChanged = {};
        }
    }

    switch (action.type) {
    case types.SET_MORTGAGE_INITIAL_DATA:
        return Object.assign({},
          state,
          propChanged);
    case types.ADD_USER_TO_MORTGAGE_PROPOSAL:
        return Object.assign({},
          state,
          { user: { name: action.formData.name, id: action.formData.userId } });
    case types.ADD_MORTGAGE_PROPOSAL:
        return state;
    default:
        return state;
    }
};

export default mortgageFormReducer;
