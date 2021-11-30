package com.playup.service;

import com.playup.model.PaymentModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CardValidationService implements  ICardValidationService,IvalidateCVV,IValidateCardNumber,IValidateName,IValidateExpiry{

    private static TicketGeneratorService instance;

    public static TicketGeneratorService getInstance() {
        if(instance == null) {
            instance = new TicketGeneratorService();
        }
        return instance;
    }

    public boolean isCardDetailsValid(PaymentModel paymentModel) {

        if(!validateName(paymentModel.getName())) {
            return false;
        }
        if(!validateCardNumber(paymentModel.getCardNumber())) {
            return false;
        }
        if(!validateDate(paymentModel.getCardExpiryDate())) {
            return false;
        }
        if(!validateCVV(paymentModel.getCvv())) {
            return false;
        }

        return true;
    }


    @Override
    public boolean validateName(String name) {
            Pattern p = Pattern.compile("^[A-Za-z\\s]+$", Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(name);
            return m.find();
    }

    @Override
    public boolean validateCardNumber(String number) {
        Pattern p = Pattern.compile("^[0-9]{16}+$");
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
        Pattern p = Pattern.compile("^[A-Za-z\\s]+$", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(Integer.toString(number));
        return m.find();
    }

    @Override
    public boolean validateDate(String expiryDate) {
        String timeStamp = new SimpleDateFormat("MM/YY").format(new Date());
        try {
            SimpleDateFormat DateFormat = new SimpleDateFormat("MM/YY");
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

