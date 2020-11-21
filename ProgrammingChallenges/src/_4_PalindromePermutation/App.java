package _4_PalindromePermutation;

public class App {
	
	/*
	 * Palindrome Permutation: Given a string, write a function to check if it is a permutation 
	 * of a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. 
	 * A permutation is a rearrangement of letters. The palindrome does not need to be limited 
	 * to just dictionary words.
	 * EXAMPLE
	 * Input: Tact Coa
	 * Output: True (permutations:"taco cat'; "atco cta '; etc.)
	 */

	public static void main(String[] args) {
		
		String s = "Tact Coa";
		System.out.println(isPalindromePermutation(s));
		System.out.println(Character.getNumericValue('z'));
		System.out.println(Character.getNumericValue('a'));

		char a = 'a';
		int a_int = (int) a;
		System.out.println(a_int);
		
	}
	
	public static boolean isPalindromePermutation(String s) {
		
		int[] table = buildCharFrequencyTable(s);
		return checkMaxOneOdd(table);
	}
	
	private static int[] buildCharFrequencyTable(String s) {
		
		int[] table = new int[Character.getNumericValue('z') -
		                      Character.getNumericValue('a') + 1];
		
		for (char c : s.toCharArray()) {
			int x = getCharNumber(c);
			if (x != -1) {
				table[x]++;
			}
		}
		return table;
	}
	
	private static int getCharNumber(Character c) {
		
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int value = Character.getNumericValue(c);
		if (a <= value && value <= z) {
			return value - a; // for zero index array
		}
		return -1; // for non-letters
	}
	
	private static boolean checkMaxOneOdd(int[] table) {
		
		boolean checker = false;
		for (int count : table) {
			if (count % 2 == 1) {
				if (checker) {
					return false;
				}
				checker = true;
			}
		}
		return true;
	}
	
}
