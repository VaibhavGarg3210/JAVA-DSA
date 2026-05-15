package com.vaibhav.two_pointer;

/**
 * @author vaibhav
 * @strategy - Two Pointer(invard)
 * @problem - Is Palidrome
 * @createdAt - 15-May-2026
 * @desc - A palindrome is a sequence of characters that reads the same forward
 *       and backward.
 */

public class PalindromeValid {

	public static boolean bruitfulCode(String str) {
		String cleaned = "";
		System.err.println("Bruitful");

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (Character.isLetterOrDigit(ch)) {
				cleaned += ch;
			}
		}

		boolean isPalindrome = true;
		int len = cleaned.length();

		for (int i = 0; i < len / 2; i++) {

			if (cleaned.charAt(i) != cleaned.charAt(len - 1 - i)) {
				isPalindrome = false;
				break;
			}
		}

		return isPalindrome;
	}

	public static boolean twoPointerInward(String str) {
		System.err.println("Two Pointer Inward");
		int left = 0;
		int right = str.length() - 1;
		while (left < right) {
			while (left < right && !Character.isLetterOrDigit(str.charAt(left))) {
				left++;
			}
			while (left < right && !Character.isLetterOrDigit(str.charAt(right))) {
				right--;
			}
			if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
				return false;
			}
			left++;
			right--;
		}
		return true;

	}

	public static void main(String[] args) {
		String str = "a dog! a panic in a pagoda.";
		System.err.println(bruitfulCode(str)? "Palindrome" : "Non Palindrome");
		System.err.println("____________________");
		System.err.println((twoPointerInward(str)) ? "Palindrome" : "Non Palindrome");

	}
}
