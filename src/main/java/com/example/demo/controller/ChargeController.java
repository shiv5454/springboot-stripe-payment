package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.ChargeDetails;
import com.example.demo.model.ChargeDetails.Currency;
import com.example.demo.service.StripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

@Controller
public class ChargeController {

	@Autowired
	private StripeService paymentsService;
	 
    @PostMapping("/charge")
    public String charge(ChargeDetails chargeDetails, Model model)
      throws StripeException {
    	chargeDetails.setDescription("Test Payment using SpringBoot App");
    	chargeDetails.setCurrency(Currency.INR);
        Charge charge = paymentsService.charge(chargeDetails);
        model.addAttribute("id", charge.getId());
        model.addAttribute("status", charge.getStatus());
        model.addAttribute("chargeId", charge.getId());
        model.addAttribute("balance_transaction", charge.getBalanceTransaction());
        return "result";
    }
 
    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex) {
        model.addAttribute("error", ex.getMessage());
        return "result";
    }
}
