package com.playup.controller.payment;

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

    @GetMapping("/paymentHistory")
    public ModelAndView paymentHistory() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("payment_history");
        return mv;
    }

    @RequestMapping(value = "/paymentHistory", method = RequestMethod.POST)
    public @ResponseBody ArrayList<PaymentModel> getPaymentHistory() {
        return paymentHistory.fetchPaymentHistory();
    }
}
