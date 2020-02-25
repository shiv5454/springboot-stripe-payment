package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.ChargeDetails;

@Controller
public class CheckoutController {
 
    @Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;
 
    @RequestMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("amount", 50 * 100);
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", ChargeDetails.Currency.EUR);
        return "checkout";
    }
    
    @RequestMapping(value={"/","/home"})
    public String home() {
    	return "home";
    }
}
