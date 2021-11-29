package com.playup.service;

import com.playup.dao.IOneTimePasswordDao;
import com.playup.dao.IUserDao;
import com.playup.dao.UserProfileDaoFactory;
import com.playup.model.IUser;
import com.playup.model.OneTimePassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

@Service
public class OneTimePasswordService implements IOneTimePasswordService {

    IUserDao userDao;
    IOneTimePasswordDao oneTimePasswordDao;
    @Autowired
    private EmailSenderService emailService;

    @Override
    public String sendOTP(String email) throws SQLException {
        OneTimePassword oneTimePassword = new OneTimePassword();

        //userDao = UserProfileDaoFactory.instance().userDao();
        oneTimePasswordDao = UserProfileDaoFactory.instance().oneTimePasswordDao();

        Random randomOTPNumber = new Random();
        int otp = randomOTPNumber.nextInt(999999);
        String otpValue = String.format("%06d", otp);

        oneTimePassword.setOneTimePassword(otpValue);
        oneTimePassword.setOneTimePasswordDate(new Date());
        oneTimePassword.setEmailId(email);

        String otpSubject = "Email Verification - PlayUP";
        String otpBody = "Your 6-digit OTP for Email Verification is - \n" + otpValue + "\n" +
                "It is valid for 15 minutes.";

        emailService.sendEmail(email, otpBody, otpSubject);
        oneTimePasswordDao.setOneTimePassword(oneTimePassword);

        return "success";
    }

    @Override
    public String verifyOTPForPasswordReset(String email, String oneTimePassword, String password) throws SQLException, ParseException {
        userDao = UserProfileDaoFactory.instance().userDao();
        oneTimePasswordDao = UserProfileDaoFactory.instance().oneTimePasswordDao();
        ArrayList<OneTimePassword> otpList = oneTimePasswordDao.getOneTimePasswordByEmail(email);
        OneTimePassword latestOtp = otpList.get(0);
        Date latestStamp = latestOtp.getOneTimePasswordDate();

        Calendar current = Calendar.getInstance();
        current.setTime(latestStamp);
        current.add(Calendar.MINUTE, 15);
        latestStamp = current.getTime();

        if (latestStamp.compareTo(new Date()) < 0) {
            return "otp_expired";
        } else {
            if (oneTimePassword.equals(latestOtp.getOneTimePassword().toString())) {
                IUser user = userDao.getUserByUserEmail(email);
                user.setPassword(password);
                userDao.updatePasswordAfterReset(user);
                return "password_update_successful";
            } else {
                return "otp_invalid";
            }
        }



    }

    @Override
    public String verifyOTP(String email, String oneTimePassword) throws SQLException, ParseException {
        oneTimePasswordDao = UserProfileDaoFactory.instance().oneTimePasswordDao();
        ArrayList<OneTimePassword> otpList = oneTimePasswordDao.getOneTimePasswordByEmail(email);
        OneTimePassword latestOtp = otpList.get(0);
        Date latestStamp = latestOtp.getOneTimePasswordDate();

        Calendar current = Calendar.getInstance();
        current.setTime(latestStamp);
        current.add(Calendar.MINUTE, 15);
        latestStamp = current.getTime();

        if (latestStamp.compareTo(new Date()) < 0) {
            return "otp_expired";
        } else {
            if (oneTimePassword.equals(latestOtp.getOneTimePassword().toString())) {
                return "email_verified";
            } else {
                return "otp_invalid";
            }
        }
    }
}
