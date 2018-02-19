package com.ubs.sudoku.UBSSudokuTest;

public class SudokuSystemException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8694713274503115370L;

	public SudokuSystemException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SudokuSystemException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public SudokuSystemException(ErrorCodes message, Throwable cause) {
		super(message.getErrorCode()+":"+message.getErrorDescription(), cause);
		// TODO Auto-generated constructor stub
	}

	public SudokuSystemException(ErrorCodes message) {
		//super(message);
		this(message,null);
	}

	public SudokuSystemException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
	
}
