package com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class ParanthesisValidator {
	private static HashMap<Character, Character>paranthesisMap= new HashMap<Character, Character>();
	static {
		paranthesisMap.put('(', ')');
		paranthesisMap.put('{', '}');
		paranthesisMap.put('[', ']');
		paranthesisMap.put('<', '>');
	}
	private static boolean validateParanthesis(String exp) {
		Stack<Character>stack = new Stack<Character>();
		for(char c : exp.toCharArray()) {
			if(paranthesisMap.containsKey(c)) 
				stack.push(c);
			else if(paranthesisMap.containsValue(c)) {
				if(stack.isEmpty() || paranthesisMap.get(stack.pop())!= c)
					return false;
			}
		}
		return stack.isEmpty();
	}
	public static void main(String[] args) {
		   String validString = "ab[c](d)ef{g}";
	        String invalidString = "ab[c](d)ef{({g})";

	        System.out.println(validateParanthesis(validString));   // Output: true
	        System.out.println(validateParanthesis(invalidString)); // Output: false
	        
	        List<String>strList = Arrays.asList("Sachin","Zaheer","Ajinkya");
	        String str = String.join(",", strList);
	        System.out.println(str);

	}

}
