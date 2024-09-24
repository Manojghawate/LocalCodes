package com.junit;

import java.util.Arrays;

public class MathOperations {

	public int calculateSumOfArray(int [] numbers) {
		return Arrays.stream(numbers).sum();
	}
}
