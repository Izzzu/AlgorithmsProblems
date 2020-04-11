package dp;

public class Regex {
    public int isMatch(final String A, final String B) {
        if (B.equals('*')) {
            return 1;
        }
        if (A.isEmpty() && B.isEmpty()) {
            return 1;
        }
        if (A.isEmpty() || B.isEmpty()) {
            return 0;
        }

        return isMatchRecursive(A, B, 0, 0, false) ? 1 : 0;
    }

    private boolean isMatchRecursive(String a, String b, int i1, int i2, boolean star) {

        if(i1 == a.length()) {
            if (i2 == b.length() || (b.charAt(i2) == '*' && i2 == b.length()-1)) {
                return true;
            } else if (b.charAt(i2) == '*') {
                return isMatchRecursive(a, b, i1, i2+1, false);
            } else return false;
        }
        if (i2 == b.length()) {
            return false;
        }

        if (star) {
            return isMatchRecursive(a, b, i1+1, i2, true) || isMatchRecursive(a, b, i1+1, i2+1, false);
        }
        if (b.charAt(i2) == '?' || b.charAt(i2) == b.charAt(i1)) {
            return isMatchRecursive(a, b, i1+1, i2+1, false);
        }
        if (b.charAt(i2) == '*') {
            return isMatchRecursive(a, b, i1, i2, true);
        }
        return false;

    }
}
