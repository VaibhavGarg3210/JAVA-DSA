package com.vaibhav.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vaibhav Garg
 * @createdAt 25-10-23
 * @updatedAt 26-10-23
 * @desc LeetCode Simple Question Add two Numbers
 */
public class TwoSum {
	
	public static void main(String args[]) {
	int[] array = {2,3,4,8};
	int target = 5;
	//simple logic
	int[] array1 = new int[2];
	array1 = simpleLogic(array,target);
	for(int i=0;i<array1.length;i++)
		System.err.println(array1[i]);
	array1 = advanceLogic(array,target);
	for(int i=0;i<array1.length;i++)
		System.err.println(array1[i]);
	}

	private static int[] advanceLogic(int[] array, int target) {
		Map<Integer,Integer> myMap = new HashMap<Integer,Integer>();
		for(int i=0;i<array.length;i++)
			myMap.put(array[i],i);
		for(int i=0;i<array.length;i++)
		{
			int complement = target-array[i];
			if(myMap.containsKey(complement)&& myMap.get(complement)!=i)
				return new int[] {i,myMap.get(complement)};
		}
		return null;
	}

	private static int[] simpleLogic(int[] array, int target) {
		int[] myArray = new int[2];
		for(int i=0;i<array.length-1;i++) {
			for(int j=i+1;j<array.length;j++) {
				if(array[i]+array[j]==target) {
					myArray[0] = i;
					myArray[1] = j;
					return myArray;
				}
			}
		}
		return null;
	}

}
