package _1_9_StringRotation;

public class App {
	
	/*
	 * String Rotation: Assume you have a method i 5 S u b s t r i n g which checks if
	 * one word is a substring of another. Given two strings, S1 and S2, write code to check if 
	 * S2 is a rotation of S1 using only one call to isSubstring (e.g., "waterbottle" is a 
	 * rotation of "erbottlewat").
	 */
	
	public static void main(String[] args) {
		
		String s = "waterbottle";
		String t = "erbottlewat";
		
		System.out.println(isRotation(s, t));
		
	}
	
	public static boolean isRotation(String s, String t) {
		
		if (s.length() > 0 && t.length() > 0 && s.length() == t.length()) {
			String ss = s + s;
			return ss.contains(t);
		}
		return false;
	}

}
