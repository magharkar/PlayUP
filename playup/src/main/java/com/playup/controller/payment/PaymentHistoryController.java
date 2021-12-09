package com.playup.controller.payment;

import com.playup.constants.ApplicationConstants;
import com.playup.model.payment.PaymentModel;
import com.playup.service.payment.IPaymentHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;

/**
 * @author Shiv Gaurang Desai
 *
 */

@Controller
public class PaymentHistoryController {
    @Autowired
    private IPaymentHistoryService paymentHistory;

    @GetMapping(ApplicationConstants.PAYMENT_HISTORY)
    public ModelAndView paymentHistory() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(ApplicationConstants.PAYMENT_HISTORY_HTML);
        return mv;
    }

    @RequestMapping(value = ApplicationConstants.PAYMENT_HISTORY, method = RequestMethod.POST)
    public @ResponseBody ArrayList<PaymentModel> getPaymentHistory() {
        return paymentHistory.fetchPaymentHistory();
    }
}
