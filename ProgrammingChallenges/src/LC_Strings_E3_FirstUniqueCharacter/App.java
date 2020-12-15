package LC_Strings_E3_FirstUniqueCharacter;

public class App {

    public static int firstUniqueChar(String s) {

        if (s == null || s.isEmpty()) return -1;

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (s.indexOf(curr) == s.lastIndexOf(curr)) {
                return s.indexOf(curr);
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        String s1 = "leetcode";
        String s2 = "loveleetcode";

        int index1 = firstUniqueChar(s1);
        int index2 = firstUniqueChar(s2);

        System.out.println(index1);
        System.out.println(index2);

    }

}
