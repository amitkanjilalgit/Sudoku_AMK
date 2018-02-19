package com.ubs.sudoku.UBSSudokuTest;

import static com.ubs.sudoku.UBSSudokuTest.ErrorCodes.ERROR_1;
import static com.ubs.sudoku.UBSSudokuTest.ErrorCodes.ERROR_2;
import static com.ubs.sudoku.UBSSudokuTest.ErrorCodes.ERROR_3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class InputReader {

	Integer[][] readAs2DArray(String fileName) throws SudokuSystemException {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		String line = null;
		Integer[][] array2D =null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileName));
			line = br.readLine();
			String[] headers = line.split(",");
			for (String header : headers) {
				List<Integer> subList = new ArrayList<Integer>();
				subList.add(Integer.parseInt(header));
				list.add(subList);
			}
			while ((line = br.readLine()) != null) {
				String[] elems = line.split(",");
				for (int i2 = 0; i2 < elems.length; i2++) {
					list.get(i2).add(Integer.parseInt(elems[i2]));
				}
			}
			int rows = list.size();
			int cols = list.get(0).size();
			array2D = new Integer[rows][cols];
			for (int row = 0; row < rows; row++) {
				for (int col = 0; col < cols; col++) {
					array2D[row][col] = list.get(row).get(col);
				}
			}
		} catch (FileNotFoundException e) {
			throw new SudokuSystemException(ERROR_1, e);
		} catch (IOException e) {
			throw new SudokuSystemException(ERROR_2, e);
		} catch(NumberFormatException e) {
			throw new SudokuSystemException(ERROR_3, e);
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				throw new SudokuSystemException(ERROR_2, e);
			}
		}
		
		return array2D;
	}

}
