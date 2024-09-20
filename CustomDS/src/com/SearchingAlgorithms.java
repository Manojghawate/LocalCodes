package com;

import java.util.Arrays;
import java.util.Scanner;

public class SearchingAlgorithms {

	public static void main(String[] args) {
		int[] arr = {1, 4, 5, 6, 7, 10, 12};
		System.out.println("Enter the number to be search");
		Scanner sc= new Scanner(System.in);
		int no = sc.nextInt();
		int result = linearSearch(arr, no);
		System.out.println("Number " + no + " is found at index "  + result + " using linear search");
		Arrays.sort(arr);
		result = binarSearch(arr, no);
		System.out.println("Number " + no + " is found at index "  + result + " using binary search");

	}
	

	private static int linearSearch(int[] arr, int target) {
		for(int i = 0; i< arr.length; i++) {
			if(arr[i] == target)
				return i;
		}
		return -1;
	}

	private static int binarSearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length -1;
		while(left<=right) {
			int mid = left + (right -left)/2;
			if(arr[mid] == target)
				return mid;
			if(arr[mid] < target)
				left = mid+1;
			else
				right = mid-1;
		}
		return -1;
	}

}
