package LC_Strings_E1_ReverseString;

import java.util.Arrays;

public class App {

    public static void reverseString(char[] s) {

        if (s == null || s.length == 0) return;

        int start = 0, end = s.length - 1;
        char temp;

        while (start < end) {
            temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }

    public static void main(String[] args) {

        char[] s1 = {'H', 'e', 'l', 'l', 'o'};

        char[] s2 = {'h', 'a', 'n', 'n', 'a', 'H'};

        reverseString(s1);
        reverseString(s2);

        System.out.println(Arrays.toString(s1));
        System.out.println(Arrays.toString(s2));

    }

}
