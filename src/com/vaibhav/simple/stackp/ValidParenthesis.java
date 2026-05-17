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
		String s1 = "[";
		System.out.println(isValids(s1));
	}

	private static boolean isValids(String s) {
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
//	public static boolean isValid(String s) {
//        Map<Character,Character> parenthesisMap = new HashMap<Character,Character>();
//        parenthesisMap.put('(',')');
//        parenthesisMap.put('[',']');
//        parenthesisMap.put('{','}');
//        Stack<Character> storeStack = new Stack<>();
//        for(Character c : s.toCharArray()){
//            if(parenthesisMap.containsKey(c)){
//                storeStack.add(c);
//            }else{
//                if(!storeStack.isEmpty() && parenthesisMap.get(storeStack.peek())==c){
//                    storeStack.pop();
//                }else{
//                    return false;
//                }
//            }
//        }
//        return storeStack.isEmpty();
//    }

}
