/**
 * @author Shiv Gaurang Desai
 */
package com.playup.controller.payment;

import com.playup.constants.ApplicationConstants;
import com.playup.model.payment.CreditCard;
import com.playup.service.email.IEmailSender;
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

    @Autowired
    private IEmailSender emailSender;

    @GetMapping("/payment")
    public String SupportMethod(Model model) {
        model.addAttribute(ApplicationConstants.CREDIT_CARD_TEXT,cardFactoryService.getCreditCard());
        return ApplicationConstants.PAYMENT_TEXT;
    }

    @PostMapping("/payment")
    public String generateSupportRequest(@ModelAttribute CreditCard creditCard, Model model) {
        HashMap<Boolean,String> validationResponse = creditCardValidationService.isCardDetailsValid(creditCard);
        if(validationResponse.containsKey(true)) {
            boolean isSuccess = paymentService.completeTransaction(creditCard);
            if(isSuccess) {
                return ApplicationConstants.PAYMENT_CONFIRMATION_TEXT;
            }else {
                model.addAttribute(ApplicationConstants.SUPPORT_ERROR,ApplicationConstants.CARD_VALIDATION_ERROR);
            }
        } else {
            model.addAttribute(ApplicationConstants.SUPPORT_ERROR,validationResponse.get(false));
        }
        return ApplicationConstants.PAYMENT_TEXT;
    }
}
