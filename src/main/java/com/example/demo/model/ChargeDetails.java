package com.example.demo.model;

public class ChargeDetails {

	private String description;
	private int amount;
	private String stripeEmail;
	private String stripeToken;
	private Currency currency;
	public enum Currency{
		INR, EUR, USD;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getStripeEmail() {
		return stripeEmail;
	}
	public void setStripeEmail(String stripeEmail) {
		this.stripeEmail = stripeEmail;
	}
	public String getStripeToken() {
		return stripeToken;
	}
	public void setStripeToken(String stripeToken) {
		this.stripeToken = stripeToken;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	
	

}

