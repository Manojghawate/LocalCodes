package com;

import java.util.Stack;

public class PostFixEvaluationUsingStack {
	private static int evaluatePostFix(String expression) {
		Stack<Integer>stack = new Stack<Integer>();
		for(char c : expression.toCharArray()) {
			if(Character.isDigit(c))
				stack.push(Integer.parseInt(String.valueOf(c)));
			else {
				int op1 = stack.pop();
				int op2 = stack.pop();
				int result = 0;
				switch (c) {
				case '+': 
					result = op2+op1;
					break;
				case '-': 
					result = op2-op1;
					break;
				case '/': 
					result = op2/op1;
					break;
				case '*': 
					result = op2*op1;
					break;

				default:
					throw new IllegalArgumentException("Unexpected value: " + c);
				}
				stack.push(result);
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		String exp = "231*+9-";
	       
        // Function call
        System.out.println("postfix evaluation: "
                           + evaluatePostFix(exp));

	}

}
