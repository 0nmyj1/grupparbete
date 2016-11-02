package se.kebr.bank.repository;

import se.kebr.bank.model.Bank;
import se.kebr.bank.security.WithdrawalException;

public class Account {

	private final String pincode;
	private final Bank bank;
	private int balance;

	public Account(Bank bank,String pincode, int balance) {
		this.pincode = pincode;
		this.balance = balance;
		this.bank = bank;
	}

	public int getBalance() {
		return balance;
	}

	private void setBalance(int balance) {
		this.balance = balance;
	}

	public String getPincode() {
		return pincode;
	}
	public Bank getBank() {
		return bank;
	}

	public void withdraw(int amount) {
		
		if(balance < amount){
			throw new WithdrawalException("Your balance is too low");
		}
		int newBalance = balance - amount;
		setBalance(newBalance);
	}

}
