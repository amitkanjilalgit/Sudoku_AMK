package com.ubs.sudoku.UBSSudokuTest;

public enum ErrorCodes {
	
	ERROR_1(1,"Specified file could not be found. Please make sure the path is valid."),
	ERROR_2(2,"Some I/O error occured. Please contact admin."),
	ERROR_3(3,"INVALID: The solved puzzle has invalid entry in the board");
	
	private final String errorDescription;
	private final Integer errorCode;
	private ErrorCodes(Integer errorCode, String errorDescription) {
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public Integer getErrorCode() {
		return errorCode;
	}
	


}
