/**
 * @author Shiv Gaurang Desai
 */
package com.playup.constants;

public class ApplicationConstants {
    public final static String ADMIN_MAIL_ID = "shiv.course@gmail.com";
    public final static String SUPPORT_EMAIL_BODY = "We are really sorry for the issue you faced. Our team will reach out to you regarding the issue.";
    public final static String SUPPORT_SUBJECT = "Re: Received Complaint #";
    public final static int MINIMUM_SUPPORT_TICKET_NUMBER = 1000;
    public final static int MAXIMUM_SUPPORT_TICKET_NUMBER = 10000;
    public final static String CIPHER_SECRET_KEY = "Shiv's Cipher";
    public final static String CHECK_SUPPORT_TICKET_NUMBER_QUERY = "select * from Support where ticketNumber = %s;";
    public final static String INSERT_SUPPORT_REQUEST_QUERY = "INSERT INTO Support (ticketNumber, name, email, venue, description) VALUES (%s, '%s', '%s', '%s', '%s');";
    public final static String EMAIL_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    public final static String EMAIL_ERROR_MESSAGE = "Email Id is not proper";
    public final static String ERROR_MESSAGE = "Some error occurred. Please try again later";
    public final static String SUPPORT_TEXT = "support";
    public final static String SUPPORT_CONFIRMATION_TEXT = "support_confirmation";
    public final static String SUPPORT_ERROR = "error";

}
