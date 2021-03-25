public class StringUtils {
    public static boolean isPalindrome(String s){
        int n = s.length();
        for (int i = 0; i < (n/2); ++i) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static String capitalize(String str) {
        return str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();
    }

    public static String encodeCesar(String message, int shiftFactor)
    {
        return applyShift(message, shiftFactor);
    }

    public static String decodeCesar(String message, int shiftFactor){
        return applyShift(message, 26-shiftFactor);
    }

    private static String applyShift(String message, int shiftFactor) {
        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c >= 'A' && c <= 'Z')
                chars[i] = (char) ((c - 'A' + shiftFactor) % 26 + 'A');
            else if (c >= 'a' && c <= 'z')
                chars[i] = (char) ((c - 'a' + shiftFactor) % 26 + 'a');
        }
        return new String(chars);
    }
}
