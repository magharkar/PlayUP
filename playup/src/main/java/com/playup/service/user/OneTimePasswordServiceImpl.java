/**
 * @author Mugdha Anil Agharkar
 */
package com.playup.service.user;

import com.playup.dao.user.IOneTimePasswordDao;
import com.playup.dao.user.IUserDao;
import com.playup.dao.user.UserProfileFactoryDao;
import com.playup.model.user.IUser;
import com.playup.model.user.OneTimePassword;
import com.playup.service.email.IEmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

@Service
public class OneTimePasswordServiceImpl implements IOneTimePasswordService {

    IUserDao userDao;
    IOneTimePasswordDao oneTimePasswordDao;
    @Autowired
    private IEmailSenderService emailService;

    @Override
    public String createOtp() {
        return null;
    }

    @Override
    public String sendOTP(String email) {
        OneTimePassword oneTimePassword = new OneTimePassword();

        oneTimePasswordDao = UserProfileFactoryDao.instance().oneTimePasswordDao();

        Random randomOTPNumber = new Random();
        int otp = randomOTPNumber.nextInt(999999);
        String otpValue = String.format("%06d", otp);

        oneTimePassword.setOneTimePassword(otpValue);
        oneTimePassword.setOneTimePasswordDate(new Date());
        oneTimePassword.setEmailId(email);
        oneTimePasswordDao.setOneTimePassword(oneTimePassword);
        return otpValue;
    }

    @Override
    public String verifyOTPForPasswordReset(String email, String oneTimePassword, String password) {
        userDao = UserProfileFactoryDao.instance().userDao();
        oneTimePasswordDao = UserProfileFactoryDao.instance().oneTimePasswordDao();
        ArrayList<OneTimePassword> otpList = null;
        otpList = oneTimePasswordDao.getOneTimePasswordByEmail(email);
        OneTimePassword latestOtp = otpList.get(otpList.size() - 1);
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
    public String verifyOTP(String email, String oneTimePassword) {
        oneTimePasswordDao = UserProfileFactoryDao.instance().oneTimePasswordDao();
        ArrayList<OneTimePassword> otpList = null;
        otpList = oneTimePasswordDao.getOneTimePasswordByEmail(email);
        OneTimePassword latestOtp = otpList.get(otpList.size() - 1);
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
