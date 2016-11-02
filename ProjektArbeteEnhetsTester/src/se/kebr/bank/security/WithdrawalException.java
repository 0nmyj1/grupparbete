package se.kebr.bank.security;

public class WithdrawalException extends RuntimeException {


	private static final long serialVersionUID = -2846939539002475154L;
	public WithdrawalException(String message) {
		super(message);
	}
}
