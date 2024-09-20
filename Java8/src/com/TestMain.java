package com;

public class TestMain {
	public static void main(String[] args) {
		try{
			String[] strs1 = {"flower", "flow", "flight"};
			System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs1));  
			String[] strs2 = {"dog", "racecar", "car"};
			System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs2));  
		}catch(Exception e){

		}
	}
	public static String longestCommonPrefix(String[] strs) throws Exception {
		if(strs.length >200){
			System.out.println("array can not have more than 200 elements");
		}
		String longestPrfix= "";
		for(int i = 0; i<=200; i++){
			char chars = strs[0].charAt(i);
			for(String str : strs){
				if(str.length()>200){
					System.out.println("string can not have more than 200 characters");
				}
				if(str.charAt(i) != chars){
					return longestPrfix;
				}
			}
			longestPrfix = longestPrfix+chars;
		}
		return longestPrfix;
	}
}
