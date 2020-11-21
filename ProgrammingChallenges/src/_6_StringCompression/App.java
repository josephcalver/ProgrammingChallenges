package _6_StringCompression;

public class App {
	
	/*
	 * String Compression: Implement a method to perform basic string compression using 
	 * the counts of repeated characters. For example, the string aabcccccaaa would become 
	 * a2blc5a3. If the "compressed"string would not become smaller than the original string, 
	 * your method should return the original string. You can assume the string has only
	 * uppercase and lowercase letters (a - z).
	 */
	
	public static void main(String[] args) {
		
		String s = "aaabbbbcccccddeeeeeeee";
		String compressed = compress(s);
		System.out.println(compressed);
		
	}
	
	public static String compress(String s) {
		// check length to see if worth compressing
		int finalLength = countCompression(s);
		if (finalLength >= s.length()) return s;
		
		StringBuilder compressed = new StringBuilder(finalLength);
		int countConsecutive = 0;
		for (int i = 0; i < s.length(); i++) {
			countConsecutive++;
			
			// if next char different to current char, append char and consecutiveCount
			if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
				compressed.append(s.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressed.toString();
	}
	
	private static int countCompression(String s) {
		
		int compressedLength = 0;
		int countConsecutive = 0;
		for (int i = 0; i < s.length(); i++) {
			countConsecutive++;
			
			if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
				compressedLength += 1 + String.valueOf(countConsecutive).length();
				countConsecutive = 0;
			}
		}
		return compressedLength;
	}
	
	

}
