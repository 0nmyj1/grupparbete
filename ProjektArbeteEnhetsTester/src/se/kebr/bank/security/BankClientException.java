package se.kebr.bank.security;

public class BankClientException extends RuntimeException {

	private static final long serialVersionUID = 6809766834782482644L;
	
	public BankClientException(String message) {
		super(message);
	}
}
