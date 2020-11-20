package _2_Permutation;

import java.util.Arrays;

public class App {
	
	// Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.

	
	public static void main(String[] args) {
		
		String str1 = "Java";
		String str2 = "avaJ";
		
		System.out.println(isPermutationSortStrings(str1, str2));
		System.out.println(isPermutationCountChars(str1, str2));
		
	}
	
	public static boolean isPermutationSortStrings(String str1, String str2) {
		
		if (str1.length() != str2.length()) return false;
		
		return sort(str1).equals(sort(str2));
	}
	
	private static String sort(String str) {
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
	
	public static boolean isPermutationCountChars(String str1, String str2) {
		
		if (str1.length() != str2.length()) return false;

		int[] letters = new int[128];
		
		char[] chars1 = str1.toCharArray();
		for (char c : chars1) {
			letters[c]++;
		}
		
		for (int i = 0; i < str2.length(); i++) {
			int c = (int) str2.charAt(i);
			letters[c]--;
			if (letters[c] < 0) {
				return false;
			}
		}
		return true;
	}

}
