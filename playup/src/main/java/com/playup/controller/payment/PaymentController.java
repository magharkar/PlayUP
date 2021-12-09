/**
 * @author Shiv Gaurang Desai
 */
package com.playup.controller.payment;

import com.playup.constants.ApplicationConstants;
import com.playup.model.payment.CreditCardModel;
import com.playup.service.payment.ICardFactoryService;
import com.playup.service.payment.ICreditCardValidationService;
import com.playup.service.payment.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.HashMap;

@Controller
public class PaymentController {
    @Autowired
    private ICreditCardValidationService creditCardValidationService;

    @Autowired
    private ICardFactoryService cardFactoryService;

    @Autowired
    private IPaymentService paymentService;

    @GetMapping("/payment")
    public String paymentGateway(Model ui) {
        ui.addAttribute(ApplicationConstants.CREDIT_CARD_TEXT,cardFactoryService.getCreditCard());
        return ApplicationConstants.PAYMENT_TEXT;
    }

    @PostMapping("/payment")
        public String completeTransaction(@ModelAttribute CreditCardModel creditCardModel, Model ui) {
        HashMap<Boolean,String> validationResponse = creditCardValidationService.isCardDetailsValid(creditCardModel);
        if(validationResponse.containsKey(true)) {
            boolean isSuccess = paymentService.completeTransaction(creditCardModel);
            if(isSuccess) {
                return ApplicationConstants.PAYMENT_CONFIRMATION_TEXT;
            }else {
                ui.addAttribute(ApplicationConstants.SUPPORT_ERROR,ApplicationConstants.CARD_VALIDATION_ERROR);
            }
        } else {
            ui.addAttribute(ApplicationConstants.SUPPORT_ERROR,validationResponse.get(false));
        }
        return ApplicationConstants.PAYMENT_TEXT;
    }
}
