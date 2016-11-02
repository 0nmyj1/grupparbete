package se.kebr.bank.model;

import se.kebr.bank.repository.Account;
import se.kebr.bank.security.BankClientException;

public class User {

	private static final int MIN_AGE = 18;

	private final String name;
	private final int age;
	private Account account;

	public User(String name, int age, Account account) {
		if (age < MIN_AGE) {
			throw new BankClientException("Must be 18 or older to create an account");
		}
		this.name = name;
		this.age = age;
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public Account getAccount() {
		return account;
	}

	public int getAge() {
		return age;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other instanceof User) {
			User otherUser = (User) other;
			return name.equals(otherUser.name);
		}
		return false;
	}

	@Override
	public int hashCode() {
		int result = 1;
		result += 37 * name.hashCode();

		return result;
	}

}
