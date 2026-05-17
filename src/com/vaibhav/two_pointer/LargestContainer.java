package com.vaibhav.two_pointer;

import java.util.Arrays;
import java.util.List;

/**
 * @author vaibhav
 * @strategy - Two Pointer(invard)
 * @problem - Largest Container
 * @desc - Using two pointer stategy
 * @date - 17/05/2026
 */
public class LargestContainer {

	public static Integer bruitfulCode(List<Integer> arr) {
		System.err.println("Bruitful Force");
		Integer maxiInteger = 0;
		Integer tempInteger = 0;
		for (int i = 0; i < arr.size(); i++) {
			for (int j = i + 1; j < arr.size(); j++) {
				tempInteger = Math.min(arr.get(i), arr.get(j)) * (j - i);
				if (tempInteger > maxiInteger)
					maxiInteger = tempInteger;
			}
		}
		return maxiInteger;

	}

	public static Integer twoPointerInward(List<Integer> arr) {
		System.err.println("Two Pointer Inward");
		int i = 0;
		int j = arr.size() - 1;
		int maxWater = Math.min(arr.get(i), arr.get(j)) * (j - i);
		while (i < j) {
			if (arr.get(i) < arr.get(j)) {
				i++;
			} else if (arr.get(i) > arr.get(j)) {
				j--;
			} else {
				j--;
				i++;
			}
			if (Math.min(arr.get(i), arr.get(j)) * (j - i) > maxWater)
				maxWater = Math.min(arr.get(i), arr.get(j)) * (j - i);
		}
		return maxWater;

	}

	public static void main(String[] args) {
		List<Integer> array = Arrays.asList(2, 9, 8, 3, 12, 6);
		System.err.println(bruitfulCode(array));
		System.err.println(twoPointerInward(array));

	}
}
