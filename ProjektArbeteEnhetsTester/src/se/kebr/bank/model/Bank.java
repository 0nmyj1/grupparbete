package se.kebr.bank.model;

import java.util.ArrayList;
import java.util.List;
import se.kebr.bank.service.BankService;

public class Bank implements BankService {

	private final String bankName;
	private final List<User> bankCustomers;

	public Bank(String bankName) {
		this.bankName = bankName;
		this.bankCustomers = new ArrayList<>();
	}

	@Override
	public Bank addCustomer(User customer) {
		bankCustomers.add(customer);
		return this;
	}

	@Override
	public Bank addCustomers(List<User> customers) {
		bankCustomers.addAll(customers);
		return this;
	}

	@Override
	public void removeCustomer(User user) {
		bankCustomers.remove(user);
	}

	public List<User> getCustomers() {
		return new ArrayList<>(bankCustomers);
	}

	public String getBankName() {
		return bankName;
	}

}
