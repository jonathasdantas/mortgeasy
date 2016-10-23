import { combineReducers } from 'redux';

// Reducers
import mortgageFormReducer from './mortgage-form-reducer';

// Combine Reducers
const reducers = combineReducers({
    mortgageFormState: mortgageFormReducer,
});

export default reducers;
