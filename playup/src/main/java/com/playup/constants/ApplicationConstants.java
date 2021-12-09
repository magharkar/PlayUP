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
    public final static String EMAIL_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    public final static String EMAIL_ERROR_MESSAGE = "Email Id is not proper";
    public final static String ERROR_MESSAGE = "Some error occurred. Please try again later";
    public final static String SUPPORT_TEXT = "support";
    public final static String PAYMENT_TEXT = "payment";
    public final static String CREDIT_CARD_TEXT = "creditCard";
    public final static String PAYMENT_CONFIRMATION_TEXT = "payment_confirmation";
    public final static String SUPPORT_CONFIRMATION_TEXT = "support_confirmation";
    public final static String SUPPORT_ERROR = "error";
    public final static String SUCCESS_ERROR = "success";
    public final static int MINIMUM_TRANSACTION_NUMBER = 1000;
    public final static int MAXIMUM_TRANSACTION_NUMBER = 10000;
    public final static String CARD_VALIDATION_ERROR = "Card details are not valid";
    public final static String UTF_FORMAT = "UTF-8";
    public final static String MESSAGE_DIGEST_INSTANCE = "SHA-1";
    public final static String ENCRYPTION_ALGORITHM = "AES";
    public final static String CIPHER_INSTANCE = "AES/ECB/PKCS5Padding";
    public final static String NAME_REGEX = "^[A-Za-z\\s]+$";
    public final static String CARD_NUMBER_REGEX = "^[0-9]{16}+$";
    public final static String CVV_REGEX = "^[0-9]{3}+$";
    public final static String DATE_FORMAT = "MM/YY";
    public final static int ENCRYPTION_MESSAGE_LENGTH = 16;
    public final static String BOOKING_CONFIRMATION_MAIL_SUBJECT = "Booking confirmed with Transaction Id #";
    public final static String BOOKING_CONFIRMATION_MAIL_BODY = "Thank you for payment. Your booking in confirmed.";
    public final static String NAME_ERROR_MESSAGE = "Name is Not Valid";
    public final static String CARD_ERROR_MESSAGE = "Card number is not valid";
    public final static String CVV_ERROR_MESSAGE = "CVV is not valid";
    public final static String EXPIRY_DATE_ERROR_MESSAGE = "Expiry date is not valid";
    public final static String EMAIL_VERIFICATION_SUBJECT = "Email Verification - PlayUP";
    public final static String EMAIL_VERIFICATION_BODY = "Your 6-digit OTP for Email Verification is - \n";
    public final static String EMAIL_VERIFICATION_VALIDITY = "It is valid for 15 minutes.";
    public final static String EMAIL_ID_ATTRIBUTE = "emailId";
    public final static String OTP_ATTRIBUTE = "oneTimePassword";
    public final static String APPLICATION_PROPERTIES_PATH = "src/main/resources/application.properties";
    public final static String EMAIL_ID_TEXT = "loggedInUser";
    public final static String PAYMENT_CONFIRMATION = "redirect:/payment_confirmation/";
    public final static String CLASH = "/";

}
