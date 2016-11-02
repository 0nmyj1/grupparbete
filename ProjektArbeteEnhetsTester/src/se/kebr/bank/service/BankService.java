package se.kebr.bank.service;

import java.util.List;

import se.kebr.bank.model.Bank;
import se.kebr.bank.model.User;

public interface BankService {

	Bank addCustomer(User customer);
	Bank addCustomers(List<User> customers);
	void removeCustomer(User user);
	
	
}
