package se.kebr.bank;

import static org.junit.Assert.*;
import java.util.HashSet;
import java.util.Set;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import se.kebr.bank.model.Bank;
import se.kebr.bank.model.User;
import se.kebr.bank.repository.Account;
import se.kebr.bank.repository.AtmMachine;
import se.kebr.bank.security.BankClientException;
import se.kebr.bank.security.WithdrawalException;

@RunWith(MockitoJUnitRunner.class)
public class BankTest {

	Bank handelsbanken;
	User user;
	AtmMachine atm;

	// alla exceptions
	// att users läggs till i banken
	// att users tas bort
	// går att se saldo
	// går att ta ut pengar
	// kvitto
	// alla publika metoder

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void shouldThrowExceptionIfAgeIsUnderEightteen() {
		exception.expect(BankClientException.class);
		user = new User("Kevin", 17, null);
	}
	@Test
	public void shouldThrowExceptionIfWithdrawalAmountIsInvalid() {
		exception.expect(WithdrawalException.class);

		handelsbanken = new Bank("handelsbanken");
		Set<Bank> bankList = new HashSet<>();
		bankList.add(handelsbanken);

		user = new User("Kevin", 18, new Account(handelsbanken, "1123", 3000));
		atm = new AtmMachine(bankList);
		atm.withdraw(user, 1250);

	}
	@Test
	public void shouldThrowExceptionWhenAmountIsBiggerThenBalance() {
		exception.expect(WithdrawalException.class);

		handelsbanken = new Bank("handelsbanken");
		Set<Bank> banklist = new HashSet<>();
		banklist.add(handelsbanken);

		user = new User("Kevin", 18, new Account(handelsbanken, "1111", 3000));
		atm = new AtmMachine(banklist);
		atm.withdraw(user, 4000);
	}
	@Test
	public void shouldThrowExceptionIfWithdrawalIsOutOfRange() {
		exception.expect(WithdrawalException.class);
		handelsbanken = new Bank("Handelsbanken");
		Set<Bank> verifiedBanks = new HashSet<>();
		verifiedBanks.add(handelsbanken);
		user = new User("Kevin", 18, new Account(handelsbanken, "1123", 15000));
		atm = new AtmMachine(verifiedBanks);
		atm.withdraw(user, 90);
	}
	@Test
	public void shouldThrowExceptionIfBankListIsEmpty() {
		exception.expect(IllegalArgumentException.class);
		handelsbanken = new Bank("handelsbanken");
		Set<Bank> banklist = new HashSet<>();
		atm = new AtmMachine(banklist);
	}
	@Test
	public void shouldThrowExceptionIfBankValuesIsNull() {
		exception.expect(IllegalArgumentException.class);
		Set<Bank> bankList = new HashSet<>();
		bankList.add(handelsbanken);
		handelsbanken = null;
		atm = new AtmMachine(bankList);
		atm.addBank(handelsbanken);
	}
	
	

}
