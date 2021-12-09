package com.playup.model.user;

/**
 * @author Mugdha Anil Agharkar
 */

public interface IUser {

    int getUserId();

    void setUserId(int userId);

    String getUserName();

    void setUserName(String userName);

    String getEmail();

    void setEmail(String email);

    String getContactNumber();

    void setContactNumber(String contactNumber);

    String getPassword();

    void setPassword(String password);

    String getConfirmPassword();

    void setConfirmPassword(String confirmPassword);

    String getCity();

    void setCity(String city);

    String getSport();

    void setSport(String sport);
    
    String getRole();
    
    void setRole(String role);
}
