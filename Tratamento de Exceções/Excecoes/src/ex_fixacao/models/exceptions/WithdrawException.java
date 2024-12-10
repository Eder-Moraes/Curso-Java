package ex_fixacao.models.exceptions;

public class WithdrawException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public WithdrawException(String msg) {
		super(msg);
	}
	
}
