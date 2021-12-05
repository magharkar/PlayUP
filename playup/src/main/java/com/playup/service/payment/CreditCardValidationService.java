/**
 * @author Shiv Gaurang Desai
 */
package com.playup.service.payment;

import com.playup.constants.ApplicationConstants;
import com.playup.model.payment.CreditCard;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
class CreditCardValidationService implements ICreditCardValidationService {
    @Override
    public boolean isCardDetailsValid(CreditCard creditCard) {
        if(!validateName(creditCard.getName())) {
            System.out.println(creditCard.getName());
            return false;
        }
        if(!validateCardNumber(creditCard.getCardNumber())) {
            System.out.println(creditCard.getCardNumber());
            return false;
        }
        if(!validateDate(creditCard.getExpiryDate())) {
            System.out.println(creditCard.getExpiryDate());
            return false;
        }
        if(!validateCVV(creditCard.getCvv())) {
            System.out.println(creditCard.getCvv());
            return false;
        }
        return true;
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
            Date d1 = DateFormat.parse(expiryDate);
            Date d2 = DateFormat.parse(timeStamp);
            if(d1.compareTo(d2)>0) {
                return true;
            }
        }
        catch(Exception e) {
            return false;
        }
        return false;
    }
}
