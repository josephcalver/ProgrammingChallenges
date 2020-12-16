package LC_Strings_E6_ConvertStringtoInt;

public class App {

    public static int atoi(String s) {

        String trimmed = s.trim();

        boolean sign = false;

        if (trimmed.charAt(0) == '-' || trimmed.charAt(0) == '+') sign = true;

        if (!sign) {
            if (!Character.isDigit(trimmed.charAt(0))) return 0;
        }

        int start = (sign) ? 1 : 0;

        int end = -1;
        for (int i = start + 1; i < trimmed.length(); i++) {
            if (Character.isWhitespace(trimmed.charAt(i)) || !Character.isDigit(trimmed.charAt(i))) {
                end = i;
                break;
            }
        }

        if (end == -1) end = trimmed.length();

        String substr = trimmed.substring(start, end);
        int num = 0;

        try {
            num = Integer.valueOf(substr);
        } catch (NumberFormatException e) {
            return Integer.MIN_VALUE;
        }

        boolean negative = false;

        if (sign) {
            if (trimmed.charAt(0) == '-') negative = true;
        }

        return (negative) ? num * -1 : num;
    }

    public static void main(String[] args) {

        String num = "     -42";
        String num2 = "4193 with words";
        String num3 = "w";
        String num4 = "-91283472332";
        String num5 = ".1";

        int result = atoi(num);
        int result2 = atoi(num2);
        int result3 = atoi(num3);
        int result4 = atoi(num4);
        int result5 = atoi(num5);

        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);

    }

}
