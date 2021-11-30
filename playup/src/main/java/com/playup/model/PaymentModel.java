package com.playup.model;

public class PaymentModel {

    private String transcationId;
    private String name;
    private String cardNumber;
    private int cvv;

    public PaymentModel(String transcationId, String name, String cardNumber, int cvv, String cardExpiryDate) {
        this.transcationId = transcationId;
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.cardExpiryDate = cardExpiryDate;
    }

    private String cardExpiryDate;

    public PaymentModel(String name, String cardNumber, int cvv, String cardExpiryDate) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.cardExpiryDate = cardExpiryDate;
    }

    public String getTranscationId() {
        return transcationId;
    }

    public void setTranscationId(String transcationId) {
        this.transcationId = transcationId;
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

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getCardExpiryDate() {
        return cardExpiryDate;
    }

    public void setCardExpiryDate(String cardExpiryDate) {
        this.cardExpiryDate = cardExpiryDate;
    }
}
