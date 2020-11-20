package _3_StringManipulation;

public class App {
	
	/* 
	 * URLify: Write a method to replace all spaces in a string with '%2e: 
	 * You may assume that the string has sufficient space at the end to hold the 
	 * additional characters, and that you are given the "true" length of the string. 
	 * (Note: if implementing in Java, please use a character array so that you can perform 
	 * this operation in place.)
	 */
	
	public static void main(String[] args) {
		
		char[] chars = { 'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'S', 'm', 'i', 't', 'h', ' ', ' ', ' ', ' ' };
		replaceSpaces(chars, 13);
		System.out.println(chars);
		
	}
	
	public static void replaceSpaces(char[] str, int trueLength) {
		
		int spaceCount = 0;
		for (int i = 0; i < trueLength; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		
		int index = trueLength + spaceCount * 2;
		
		for (int i = trueLength - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[index - 1] = '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
				index = index - 3;
			} else {
				str[index - 1] = str[i];
				index--;
			}
		}
	}
}
