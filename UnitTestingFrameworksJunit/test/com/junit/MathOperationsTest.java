package com.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * @author manoj.ghawate
 */
class MathOperationsTest {
	private MathOperations operations = new MathOperations();
	
	@Test
	private void calculateSumOfArray() {
		assertEquals(30, operations.calculateSumOfArray(new int [] {5,10,15}));
	}
	@Test
	public void calculateSumOfEmptyArray() {
		assertEquals(0, operations.calculateSumOfArray(new int [] {}));
	}


}
