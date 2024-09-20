package com;

import java.util.Arrays;

public class CustomRope {
	private RopeNode root;
	public CustomRope(String data) {
		root = new RopeNode(data);
	}
	public CustomRope(RopeNode node) {
		root = node;
	}
	public static  CustomRope concat(CustomRope left, CustomRope right) {
		return new CustomRope(new RopeNode(left.root,right.root));
	}
	public CustomRope insert(int index,String data) {
		return new CustomRope(insertRec(root,data, index));
	}
	private RopeNode insertRec(RopeNode root, String data, int index) {
		if(root.data != null) {
			StringBuilder builder = new StringBuilder(root.data);
			builder.insert(index, data);
			return new RopeNode(builder.toString());
		}
		if(index < root.weight) {
			//root.left = insertRec(root.left, data, index);
			RopeNode newLeft = insertRec(root.left, data, index);
			return new RopeNode(newLeft,root.right);
		}else {
			//root.right = insertRec(root.right, data, index);
			RopeNode newRight = insertRec(root.right, data, index-root.weight);
			return new RopeNode(root.left,newRight);
		}
		//return root;
	}
	public CustomRope insert(String data) {
		return new CustomRope(insertRec(root,data));
	}
	private RopeNode insertRec(RopeNode root, String data) {
		if(root.data != null) {
			return new RopeNode(root.data + data);
		}
		 RopeNode newRight = insertRec(root.right, data);
		 return new RopeNode(root.left,newRight);
	}
	public char charAt(int index) {
		return charAtRec(root,index);
	}
	private char charAtRec(RopeNode root, int index) {
		if(root.data != null) {
			return root.data.charAt(index);
		}
		if(index < root.weight) {
			return charAtRec(root.left, index);
		}else {
			return charAtRec(root.right, index-root.weight);
		}
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		toStringRec(sb,root);
		return sb.toString();
	}
	private void toStringRec(StringBuilder sb, RopeNode root) {
		if(root == null) {
			return;
		}
		if(root.data != null)
			sb.append(root.data);
		else {
			toStringRec(sb, root.left);
			toStringRec(sb, root.right);
		}
	}
	
	public CustomRope sort() {
		String data = toString();
		char [] charArray = data.toCharArray();
		Arrays.sort(charArray);
		return new CustomRope(new String(charArray));
	}
	private static class RopeNode{
		int weight;
		String data;
		RopeNode left;
		RopeNode right;
		public RopeNode(String data) {
			this.data = data;
			this.weight = data.length();
		}
		public RopeNode(RopeNode left,RopeNode right) {
			this.left = left;
			this.right = right;
			this.weight = left == null ? 0 : left.weight;
		}

	}
	public int length() {
		return length(root);
	}
	private int length(RopeNode root) {
		if(root ==null) {
			return 0;
		}
		if(root.data != null)
			return root.data.length();
		
		return length(root.left)+length(root.right);
	}
	public static void main(String[] args) {
		CustomRope rope1 = new CustomRope("Hello ");
		CustomRope rope2 = new CustomRope("World!");
		CustomRope rope = CustomRope.concat(rope1, rope2);

        System.out.println("Concatenated Rope: " + rope.toString());  // Output: Hello World!
        System.out.println("Length of Rope: " + rope.length());      // Output: 12
        System.out.println("Character at index 6: " + rope.charAt(6)); // Output: W

        // Insert a string at index 5
        CustomRope modifiedRope = rope.insert(5, ", ");
        System.out.println("Modified Rope: " + modifiedRope.toString()); // Output: Hello, World!

        // Insert a string at the end
        CustomRope appendedRope = modifiedRope.insert(" Have a nice day!");
        System.out.println("Appended Rope: " + appendedRope.toString()); // Output: Hello, World! Have a nice day!

        // Sort the Rope
        CustomRope sortedRope = appendedRope.sort();
        System.out.println("Sorted Rope: " + sortedRope.toString()); // Output:   !aaaaacddehHllnnooossttWyy

	}

}
