package com.playup.constants;

/**
 * @Author Shiv Gaurang Desai
 */

public class QueryConstants {
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
}
