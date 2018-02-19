package com.ubs.sudoku.UBSSudokuTest;

import static com.ubs.sudoku.UBSSudokuTest.ErrorCodes.ERROR_1;
import static com.ubs.sudoku.UBSSudokuTest.ErrorCodes.ERROR_3;

import java.util.Arrays;

public class SudokuValidator 
{
	
	
	public static void main(String[] args) throws Exception {
		
		Integer[][] sudokuInputMatrix;
		sudokuInputMatrix = readInput(args);
		
		if(isPuzzleValid(sudokuInputMatrix)) {
			System.out.println("VALID");
			return;
		}
		System.out.println(ERROR_3.getErrorDescription());
	}
	
	private static Integer[][] readInput(String[] args) throws SudokuSystemException{
		String fileName = args[0];
		if(fileName == null || fileName.isEmpty()) {
			throw new SudokuSystemException(ERROR_1);
		}
		InputReader inputReader = new InputReader();
		return inputReader.readAs2DArray(fileName);
	}

	/**
	 * 
	 * check row and column for duplicates check submatrix for duplicates.
	 */
	static boolean isPuzzleValid(Integer[][] sudokuInputMatrix) {
		for (int i = 0; i < 9; i++) {
			Integer[] row = new Integer[9];
			Integer[] square = new Integer[9];
			Integer[] column = sudokuInputMatrix[i].clone();

			for (int j = 0; j < 9; j++) {
				row[j] = sudokuInputMatrix[j][i];
				square[j] = sudokuInputMatrix[(i / 3) * 3 + j / 3][i * 3 % 9+ j % 3];
			}
			if (!(validate(column) && validate(row) && validate(square)))
				return false;
		}
		return true;
	}

	private static boolean validate(Integer[] check) {
		int i = 0;
		Arrays.sort(check);
		for (Integer number : check) {
			if (number != ++i)
				return false;
		}
		return true;
	}
}
