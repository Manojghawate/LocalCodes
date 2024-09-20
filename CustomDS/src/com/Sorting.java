package com;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Sorting {

	public static void main(String[] args) {
		 int arr[] = {64,25,12,22,11};
	        selectionSort(arr);
	        System.out.println("Selection Sorted array");
	        printArray(arr);
	        System.out.println("Bubbled Sorted array");
	        bubbleSort(arr);
	        printArray(arr);
	        System.out.println("Insersion Sorted array");
	        insertionSort(arr);
	        printArray(arr);

	}
	private static void insertionSort(int[] arr) {
		for(int i = 1; i<arr.length; i++) {
			int key = arr[i];
			int j = i-1;
			for(;j>=0 && arr[j]>key;j++) {
				arr[j+1] = arr[j];
			}
			arr[j+1] = key;
		}
	}
	private static void bubbleSort(int[] arr) {
		for(int i = 0; i< arr.length; i++) {
			boolean isSwap = false;
			for(int j = i+1; j<arr.length-i-1; j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1]=temp;
					isSwap = true;
				}
				if(!isSwap)
					break;
			}
		}
	}
	private static void selectionSort(int[] arr) {
		for(int i = 0; i<arr.length; i++) {
			int minIndex = i;
			for(int j = i+1; j<arr.length;j++) {
				if(arr[j] < arr[minIndex])
					minIndex = j;
			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}
	
	private static void printArray(int[] arr) {
		String result = Arrays.stream(arr).mapToObj(n -> String.valueOf(n)).collect(Collectors.joining(", "));
		System.out.println(result);
	}

}
