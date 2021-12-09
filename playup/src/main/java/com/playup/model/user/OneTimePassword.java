package com.playup.model.user;

import java.util.Date;

/**
 * @author Mugdha Anil Agharkar
 */
public class OneTimePassword {
    private Integer id;
    private String userName;
    private String emailId;
    private String oneTimePassword;
    private Date oneTimePasswordDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getOneTimePassword() {
        return oneTimePassword;
    }

    public void setOneTimePassword(String oneTimePassword) {
        this.oneTimePassword = oneTimePassword;
    }

    public Date getOneTimePasswordDate() {
        return oneTimePasswordDate;
    }

    public void setOneTimePasswordDate(Date oneTimePasswordDate) {
        this.oneTimePasswordDate = oneTimePasswordDate;
    }
}
