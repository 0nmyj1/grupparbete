package se.kebr.bank.service;

import se.kebr.bank.model.User;
import se.kebr.bank.repository.AtmMachine;

public interface AtmService {

	int balance(User user);
	AtmMachine withdraw(User user,int amount);
	String getReceipt(User user);
	
}
