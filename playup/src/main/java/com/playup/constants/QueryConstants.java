package com.playup.constants;

/**
 * @author Shiv Gaurang Desai
 */

public class QueryConstants {
    public final static String DB_URL = "jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_1_TEST";
    public final static String DB_USERNAME = "CSCI5308_1_TEST_USER";
    public final static String DB_PASSWORD = "cheTee8uzae0eiDa";
    public final static String CHECK_SUPPORT_TICKET_NUMBER_QUERY = "SELECT * from Support where ticketNumber = %s;";
    public final static String INSERT_SUPPORT_REQUEST_QUERY = "INSERT INTO Support (ticketNumber, name, email, venue, description) VALUES (%s, '%s', '%s', '%s', '%s');";
    public final static String CHECK_TRANSACTION_ID_NUMBER_QUERY = "SELECT * from Payment where transactionId = %s;";
    public final static String INSERT_TRANSACTION_QUERY = "INSERT INTO Payment (TransactionId, name, amount, timeStamp, cardNumber, email) VALUES (%s, '%s', '%s', '%s', '%s', '%s');";
    public final static String FETCH_PAYMENT_HISTORY = "SELECT * from Payment where email = '%s';";
    public final static String PAYMENT_QUERY_TRANSACTION_ID = "transactionId";
    public final static String PAYMENT_QUERY_NAME = "name";
    public final static String PAYMENT_QUERY_CARD_NUMBER = "cardNumber";
    public final static String PAYMENT_QUERY_AMOUNT = "amount";
    public final static String PAYMENT_QUERY_TIME_STAMP = "timeStamp";
    public final static String PAYMENT_QUERY_EMAIL = "email";
    public final static String INSERT_INTO_MATCHES_TABLE = "INSERT INTO Tournament (Tournament_id, matches_list) VALUES ('";
    public final static String INSERT_INTO_TOURNAMENT_TABLE = "INSERT INTO Tournament_Details (userId, tournament_id, sport_name, team_number) VALUES ('";
    public final static String GET_VENUE_BY_ID = "Select * from Venues where venue_id=";
    public final static String GET_SLOT_BY_VENUE_ID = "Select * from venue_slot_mapping where venue_id=";
    public final static String GET_LOCATION_OF_ALL_VENUES = "Select venue_id, latitude, longitude from Venues";
    public final static String INSERT_USER = "Insert into User (email, phone, password, sport, city, username) values ";
    public final static String QUERY_SEPERATOR = "','";
    public final static String USER_SET_PASSWORD = "Update User SET password='";
    public final static String INSERT_USER_OTP = "Insert into user_otp_mapping (otp, email, date) values ";
    public final static String SELECT_USER_OTP = "Select * from user_otp_mapping where email='";
    public final static String SELECT_USER = "Select * from User where email='";
    public final static String SELECT_VENUE_SLOT = "Select * from venue_slot_mapping where sport='";
    public final static String UPDATE_SLOT_QUERY = "Update venue_slot_mapping SET booking_status= 'unavailable' WHERE venue_id='";
    public final static String UPDATE_VENUES = "Update Venues SET available_slots='";
}
