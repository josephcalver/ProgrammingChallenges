package _1_1_UniqueChars;

public class App {
	
	// Is Unique: Implement an algorithm to determine if a string has all unique characters. 
	// What if you cannot use additional data structures?

	public static void main(String[] args) {
		
		String str = "Joseph";
		String str2 = "afhjkle!";
		System.out.println(isUnique(str));
		System.out.println(isUniqueBoolArray(str2));

		
	}
	
	// No additional space
	// O(N^2)
	public static boolean isUnique(String str) {
		
		String lower = str.toLowerCase();
		char[] chars = lower.toCharArray();
		
		for (int i = 0; i < chars.length - 1; i++) {
			for (int j = i + 1; j < chars.length; j++) {
				// System.out.println(chars[i] + ", " + chars[j]);
				if (chars[i] == chars[j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	// With additional space -- boolean array as checklist for ASCII chars
	public static boolean isUniqueBoolArray(String str) {
		
		if (str.length() > 128) return false;
		
		boolean[] checklist = new boolean[128];
		
		for (int i = 0; i < str.length(); i++) {
			int asciiCode = str.charAt(i);
			// System.out.println(asciiCode + ", " + str.charAt(i));
			if (checklist[asciiCode]) {
				return false;
			}
			checklist[asciiCode] = true;
		}
		return true;
	}
	
}
