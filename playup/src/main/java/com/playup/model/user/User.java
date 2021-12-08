//@Author Mugdha Agharkar

package com.playup.model.user;

public class User implements IUser {

    private int userId;
    private String userName;
    private String emailId;
    private String contactNumber;
    private String password;
    private String confirmPassword;
    private String city;
    private String sport;

    @Override
    public int getUserId() {
        return userId;
    }

    @Override
    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getEmail() {
        return emailId;
    }

    @Override
    public void setEmail(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String getContactNumber() {
        return contactNumber;
    }

    @Override
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getConfirmPassword() {
        return confirmPassword;
    }

    @Override
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String getSport() {
        return sport;
    }

    @Override
    public void setSport(String sport) {
        this.sport = sport;
    }
}
