/**
 * @author Shiv Gaurang Desai
 */
package com.playup.controller.payment;

import com.playup.constants.ApplicationConstants;
import com.playup.model.payment.CreditCard;
import com.playup.service.payment.ICardFactoryService;
import com.playup.service.payment.ICreditCardValidationService;
import com.playup.service.payment.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PaymentController {
    @Autowired
    private ICreditCardValidationService creditCardValidationService;

    @Autowired
    private ICardFactoryService cardFactoryService;

    @Autowired
    private IPaymentService paymentService;

    @GetMapping("/payment")
    public String SupportMethod(Model model) {
        model.addAttribute("creditCard",cardFactoryService.getCreditCard());
        return "payment";
    }

    @PostMapping("/payment")
    public String generateSupportRequest(@ModelAttribute CreditCard creditCard, Model model) {
        if(creditCardValidationService.isCardDetailsValid(creditCard)) {
            paymentService.completeTransaction(creditCard);
        } else {
            model.addAttribute(ApplicationConstants.SUPPORT_ERROR,ApplicationConstants.CARD_VALIDATION_ERROR);
        }
        return "payment";
    }
}
