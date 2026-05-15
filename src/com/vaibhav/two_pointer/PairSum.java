package com.vaibhav.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author vaibhav
 * @strategy - Two Pointer(invard)
 * @problem - Pair Sum
 * @desc - array + assending order(sorted) + target value
 */

public class PairSum {

	public  static  ArrayList<Integer> bruitfulCode(List<Integer> arr, Integer target) {

		System.err.println("Bruit Force Force");
		for (int i = 0; i < arr.size(); i++) {
			for (int j = i + 1; j < arr.size(); j++)
				if (arr.get(i) + arr.get(j) == target) {
					ArrayList<Integer> result = new ArrayList<>();
					result.add(arr.get(i));
					result.add(arr.get(j));
					return result;
				}
		}
		return null;

	}

	public  static ArrayList<Integer> twoPointerInward(List<Integer> arr, Integer target) {
		System.err.println("Two Pointer Inward");
		int i=0;
		int j = arr.size()-1;
		while(i<j) {
			System.err.println(arr.get(i)+"-"+arr.get(j));
			if(arr.get(i)+arr.get(j)==target) {
				ArrayList<Integer> result = new ArrayList<>();
				result.add(arr.get(i));
				result.add(arr.get(j));
				return result;
			}
			if(arr.get(i)<arr.get(j)) {
				i++;
			}else {
				j--;
			}
		}
		return null;

	}

	public static void main(String[] args) {
		List<Integer> sortedArray = Arrays.asList(-5, 3, 4, 6, 12);
		Integer target = 7;
		System.err.println(bruitfulCode(sortedArray, target));
		System.err.println(twoPointerInward(sortedArray, target));

	}
}
