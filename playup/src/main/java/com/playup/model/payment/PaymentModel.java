package com.playup.model.payment;

/**
 * @Author Shiv Gaurang Desai
 */
public class PaymentModel {
    private int transactionId;
    private String name;
    private String cardNumber;
    private int amount;
    private String timeStamp;
    private String loggedInUserEmail;

    public String getLoggedInUserEmail() {
        return loggedInUserEmail;
    }

    public void setLoggedInUserEmail(String loggedInUserEmail) {
        this.loggedInUserEmail = loggedInUserEmail;
    }

    public PaymentModel(){}

    public PaymentModel(int transactionId, String name, String cardNumber, int amount, String timeStamp, String loggedInUserEmail) {
        this.transactionId = transactionId;
        this.name = name;
        this.cardNumber = cardNumber;
        this.amount = amount;
        this.timeStamp = timeStamp;
        this.loggedInUserEmail = loggedInUserEmail;
    }

    public PaymentModel(String name, String cardNumber, int amount, String timeStamp) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.amount = amount;
        this.timeStamp = timeStamp;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

 }
