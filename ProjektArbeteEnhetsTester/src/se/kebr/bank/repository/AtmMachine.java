package se.kebr.bank.repository;

import java.util.HashSet;
import java.util.Set;

import se.kebr.bank.model.Bank;
import se.kebr.bank.model.User;
import se.kebr.bank.security.WithdrawalException;
import se.kebr.bank.service.AtmService;

public class AtmMachine implements AtmService {
	private static final int MIN_WITHDRAWAL = 100;
	private static final int MAX_WITHDRAWAL = 10000;

	Set<Bank> verifiedBanks;

	public AtmMachine(Set<Bank> verifiedBanks) {
		if (verifiedBanks.size() == 0) {
			throw new IllegalArgumentException("No banks");
		}
		this.verifiedBanks = verifiedBanks;
	}

	public AtmMachine addBank(Bank bank) {
		if (bank == null || bank.getBankName().length() <= 2 || bank.getBankName() == null) {
			throw new IllegalArgumentException("Empty bank");
		}
		verifiedBanks.add(bank);
		return this;
	}

	@Override
	public int balance(User user) {
		return user.getAccount().getBalance();
	}

	@Override
	public AtmMachine withdraw(User user, int amount) {
		if (checkWithdrawal(amount)) {
			user.getAccount().withdraw(amount);
		}
		return this;
	}

	@Override
	public String getReceipt(User user) {
		return "Bank: " + user.getAccount().getBank().getBankName() + "\nCustomer: " + user.getName() + "\nCurrent balance: "
				+ user.getAccount().getBalance();

	}

	private boolean checkWithdrawal(int amount) {
		if (amount < MIN_WITHDRAWAL || amount > MAX_WITHDRAWAL) {
			throw new WithdrawalException("Invalid amount");
		}
		if(!(amount % 100 == 0)){
			throw new WithdrawalException("Invalid withdrawal amount");
		}
		return true;
	}

	public Set<Bank> getBanks() {
		return new HashSet<>(verifiedBanks);
	}

}
