package com.vaibhav.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author vaibhav
 * @strategy - Two Pointer(invard)
 * @problem - Pair Sum
 * @desc - array + assending order(sorted) + target value = 0
 * @Input: nums = [0, -1, 2, -3, 1]
 * @Output: [[-3, 1, 2], [-1, 0, 1]]
 */

public class TrippleSum {

	public static List<ArrayList<Integer>> bruitfulCode(List<Integer> arr) {
		List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		System.err.println("Bruit Force Force");
		for (int i = 0; i < arr.size(); i++) {
			for (int j = i + 1; j < arr.size(); j++)
				for (int k = j + 1; k < arr.size(); k++)
					if (arr.get(i) + arr.get(j) + arr.get(k) == 0) {
						ArrayList<Integer> result = new ArrayList<>();
						result.add(arr.get(i));
						result.add(arr.get(j));
						result.add(arr.get(k));
						Collections.sort(result);
						list.add(result);
					}
		}
		return list;

	}

	public static List<ArrayList<Integer>> trippleSumInward(List<Integer> nums) {
		System.err.println("Two Pointer Inward");
		ArrayList<ArrayList<Integer>> triplets = new ArrayList<>();
		// Sort the input list.
		Collections.sort(nums);
		for (int i = 0; i < nums.size(); i++) {
			// Optimization: triplets consisting of only positive numbers will never sum
			// to 0.
			if (nums.get(i) > 0) {
				break;
			}
			// To avoid duplicate triplets, skip 'a' if it's the same as the previous
			// number.
			if (i > 0 && nums.get(i).equals(nums.get(i - 1))) {
				continue;
			}
			// Find all pairs that sum to a target of '-a' ('-nums[i]').
			ArrayList<ArrayList<Integer>> pairs = pair_sum_sorted_all_pairs(nums, i + 1, -nums.get(i));
			for (ArrayList<Integer> pair : pairs) {
				ArrayList<Integer> triplet = new ArrayList<>();
				triplet.add(nums.get(i));
				triplet.addAll(pair);
				triplets.add(triplet);
			}
		}
		return triplets;

	}

	private static ArrayList<ArrayList<Integer>> pair_sum_sorted_all_pairs(List<Integer> nums, int start,
			int target) {
		ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();
		int left = start;
		int right = nums.size() - 1;
		while (left < right) {
			int sum = nums.get(left) + nums.get(right);
			if (sum == target) {
				ArrayList<Integer> pair = new ArrayList<>();
				pair.add(nums.get(left));
				pair.add(nums.get(right));
				pairs.add(pair);
				left += 1;
				// To avoid duplicate '[b, c]' pairs, skip 'b' if it’s the same as the
				// previous number.
				while (left < right && nums.get(left).equals(nums.get(left - 1))) {
					left += 1;
				}
			} else if (sum < target) {
				left += 1;
			} else {
				right -= 1;
			}
		}
		return pairs;
	}

	public static void main(String[] args) {
		List<Integer> sortedArray = Arrays.asList(0, -1, 2, -3, 1);
		System.err.println(bruitfulCode(sortedArray));
		System.err.println(trippleSumInward(sortedArray));

	}
}
