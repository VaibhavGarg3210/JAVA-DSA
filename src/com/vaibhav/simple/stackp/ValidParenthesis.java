package com.vaibhav.simple.stackp;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author vaibhav
 * @desc use stack LIFO - Nested Structure approach
 * @date 17/5/2026
 */
public class ValidParenthesis {

	public static void main(String args[]) {
		String s = "([]{})";
		System.out.println(isValid(s));
	}

	private static boolean isValid(String s) {
		Map<Character, Character> map = new HashMap<Character, Character>();
		Stack<Character> stack = new Stack<>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		for (Character character : s.toCharArray()) {
			if (map.containsKey(character))
				stack.push(character);
			else {
				if (!stack.isEmpty() && map.get(stack.peek()) == character) {
					stack.pop();
				} else {
					return false;
				}

			}
		}

		return stack.isEmpty();
	}

}
