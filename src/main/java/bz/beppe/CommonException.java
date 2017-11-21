package bz.beppe;

public class CommonException extends Exception{

	private String errorCode;
	
	public CommonException(String errorCode, String errorMsg) {
		super(errorMsg);
		this.errorCode = errorCode;
	}
}
