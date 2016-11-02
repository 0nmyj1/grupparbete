package se.kebr.bank.repository;

import java.util.HashSet;
import java.util.Set;

import se.kebr.bank.model.Bank;
import se.kebr.bank.model.User;

public class Main {
	public static void main(String[] args) {

		Bank handelsBanken = new Bank("Handelsbanken");
		Bank swedBank = new Bank("Swedbank");
		Bank seb = new Bank("SEB");
		Bank nordea = new Bank("Nordea");
		Set<Bank> banks = new HashSet<>();
		banks.add(handelsBanken);
		banks.add(swedBank);
		banks.add(seb);
		banks.add(nordea);
		AtmMachine atmMachine = new AtmMachine(banks);

	User user = new User("Kevin", 24, new Account(nordea, "1234", 50000));
	atmMachine.withdraw(user, 100);
	System.out.println(atmMachine.getReceipt(user));
	}
	
	
	
}
