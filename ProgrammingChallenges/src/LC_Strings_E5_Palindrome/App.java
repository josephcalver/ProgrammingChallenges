package LC_Strings_E5_Palindrome;

public class App {

    public static boolean isPalindromePermutation(String s) {

        if (s == null) return false;
        String lower = s.toLowerCase();
//        System.out.println(lower);

        int[] table = new int[26];
        int ascii;

        for (char c : lower.toCharArray()) {
            if (Character.isLetter(c)) {
                ascii = c - 'a';
//                System.out.println(c + " = " + ascii);
                table[ascii]++;
            }
        }

//        System.out.println(Arrays.toString(table));

        boolean countOne = false;

        for (int i : table) {
            if (i % 2 == 1) {
                if (countOne) {
                    return false;
                }
                countOne = true;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String s) {

        String lowercase = s.toLowerCase();
        StringBuilder sb = new StringBuilder();

        for (char c : lowercase.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }

        char[] chars = sb.toString().toCharArray();
        System.out.println(chars);
        int left = 0, right = chars.length - 1;

        while (left <= right) {
            if (chars[left++] != chars[right--]) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindrome2(String s) {

        String lowercase = s.toLowerCase();
        char[] chars = lowercase.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left <= right) {
            if (Character.isLetterOrDigit(chars[left])
                    && Character.isLetterOrDigit(chars[right])
                    && chars[left] == chars[right]) {
                left++;
                right--;
            } else if (!Character.isLetterOrDigit(chars[left])) {
                    left++;
            } else if (!Character.isLetterOrDigit(chars[right])) {
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";
        String t = "0P";

        boolean result = isPalindrome2(s);

        System.out.println(result);

    }

}
