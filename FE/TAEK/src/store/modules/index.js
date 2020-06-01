import { combineReducers } from 'redux';
import date from './date/dateReducer';
import person from './person/personReducer';
import charge from './charge/chargeReducer';
import rooms from './rooms/roomsReducer';
import reservation from './reservation/reservationReducer';
import loaction from './location/locationReducer';

export default combineReducers({
    date,
    person,
    charge,
    rooms,
    reservation,
    loaction,
});