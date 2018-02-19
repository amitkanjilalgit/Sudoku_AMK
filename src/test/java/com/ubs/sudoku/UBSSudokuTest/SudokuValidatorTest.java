package com.ubs.sudoku.UBSSudokuTest;


import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



/**
 * Unit test for SudokuValidatorTest
 */
public class SudokuValidatorTest 
{
	
	private Integer[][] input_valid=null;
	private Integer[][] input_invalid = null;
	private Integer[][] input_junkChar = null;
	private InputReader inputReader;
	
	@Before
    public void setUp() throws Exception {
    	inputReader = new InputReader();
    	input_valid = inputReader.readAs2DArray("src/main/resources/csv/Input_valid.csv");
    	input_invalid = inputReader.readAs2DArray("src/main/resources/csv/Input_invalid.csv");
    }

	@After
    public void cleanUp() {
    	inputReader = null;
    	input_valid = null;
    	input_invalid = null;
    	input_junkChar = null;
    }
    
	@Test(expected = SudokuSystemException.class)
	public void testInvalidMatrixEntry() throws Exception {
		input_junkChar = inputReader.readAs2DArray("src/main/resources/csv/Input_junkChar.csv");
		SudokuValidator.isPuzzleValid(input_junkChar);
    }
    
	/**
	 * each row has unique numbers between 1-9
	 * @throws Exception
	 */
    @Test
    public void testValidRowEntry() throws Exception {
    	boolean isValid = SudokuValidator.isPuzzleValid(input_valid);
    	assertEquals(Boolean.TRUE,Boolean.valueOf(isValid));
    	
    }
    
    /**
     * invalid entry covers row and column and eventually submatrix.
     * @throws Exception
     */
    @Test
    public void testInvalidEntry() throws Exception {
    	boolean isValid = SudokuValidator.isPuzzleValid(input_invalid);
    	assertEquals(Boolean.FALSE,Boolean.valueOf(isValid));
    }
}
