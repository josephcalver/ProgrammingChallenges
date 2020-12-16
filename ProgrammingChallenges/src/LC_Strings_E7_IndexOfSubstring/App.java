package LC_Strings_E7_IndexOfSubstring;

public class App {

    public static int indexOfSubstring(String haystack, String needle) {

        if (needle.isEmpty()) return 0;

        for (int i = 0; i < haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                inner: for (int j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(j + i) != needle.charAt(j)) {
                        break inner;
                    }
                }
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        String haystack = "a";
        String needle = "a";
        int index = haystack.indexOf(needle);
        System.out.println(index);


    }

}
