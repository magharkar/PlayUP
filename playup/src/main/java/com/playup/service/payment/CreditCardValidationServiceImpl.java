package com.playup.service.payment;

import com.playup.constants.ApplicationConstants;
import com.playup.model.payment.CreditCardModel;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Shiv Gaurang Desai
 */
@Service
public class CreditCardValidationServiceImpl implements ICreditCardValidationService {
    @Override
    public HashMap<Boolean,String> isCardDetailsValid(CreditCardModel creditCardModel) {
        HashMap<Boolean,String> response = new HashMap<>();
        if(!validateName(creditCardModel.getName())) {
            response.put(false,ApplicationConstants.NAME_ERROR_MESSAGE);
            return response;
        }
        if(!validateCardNumber(creditCardModel.getCardNumber())) {
            response.put(false,ApplicationConstants.CARD_ERROR_MESSAGE);
            return response;
        }
        if(!validateCVV(creditCardModel.getCvv())) {
            response.put(false,ApplicationConstants.CVV_ERROR_MESSAGE);
            return response;
        }
        if(!validateDate(creditCardModel.getExpiryDate())) {
            response.put(false,ApplicationConstants.EXPIRY_DATE_ERROR_MESSAGE);
            return response;
        }
        response.put(true,ApplicationConstants.SUCCESS_ERROR);
        return response;
    }

    @Override
    public boolean validateName(String name) {
        Pattern p = Pattern.compile(ApplicationConstants.NAME_REGEX, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(name);
        return m.find();
    }

    @Override
    public boolean validateCardNumber(String number) {
        Pattern p = Pattern.compile(ApplicationConstants.CARD_NUMBER_REGEX);
        Matcher m = p.matcher(number);
        if(!m.find()) {
            return false;
        }
        int[] cardArray = new int[16];
        for(int i = 0; i<16;i++) {
            cardArray[i] = Integer.parseInt(number.substring(i,i+1));
        }

        int total = 0;

        for(int i = cardArray.length-1; i>=0;i--) {
            int tempTotal;
            if(i%2==0) {
                tempTotal = cardArray[i]*2;
            }else {
                tempTotal = cardArray[i];
            }
            if(tempTotal>9) {
                tempTotal = (tempTotal%10) + (tempTotal/10);
            }
            total += tempTotal;
        }
        if(total%10==0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean validateCVV(int number) {
        Pattern p = Pattern.compile(ApplicationConstants.CVV_REGEX, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(Integer.toString(number));
        return m.find();
    }

    @Override
    public boolean validateDate(String expiryDate) {
        String timeStamp = new SimpleDateFormat(ApplicationConstants.DATE_FORMAT).format(new Date());
        try {
            SimpleDateFormat DateFormat = new SimpleDateFormat(ApplicationConstants.DATE_FORMAT);
            Date expiry = DateFormat.parse(expiryDate);
            Date current = DateFormat.parse(timeStamp);
            if(expiry.compareTo(current)>0) {
                return true;
            }
        }
        catch(Exception e) {
            return false;
        }
        return false;
    }
}
