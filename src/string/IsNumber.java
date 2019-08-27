package string;

public class IsNumber {

    public static int isNumber(final String B) {
        String A = B.trim();

        if (A.length() == 0) {
            return 0;
        }

        if (A.length() == 1 && !Character.isDigit(A.charAt(0))) {
            return 0;
        }

        if (A.charAt(0) != '+' && A.charAt(0)
                != '-' && A.charAt(0) != '.' && !Character.isDigit(A.charAt(0))) {
            return 0;
        }

        boolean flagE = false;

        for (int i = 1; i<A.length(); i++) {
            if (!Character.isDigit(A.charAt(i)) && A.charAt(i) != '+' && A.charAt(i)
                    != '-' && A.charAt(i) != '.' && A.charAt(i) != 'e') {
                return 0;
            }

            if (A.charAt(i) == '.') {
                if (flagE || i+1>=A.length() || !Character.isDigit(A.charAt(i+1))) {
                    return 0;
                }
            } else if (A.charAt(i) == 'e') {
                flagE = true;
                if (i+1>=A.length() || !Character.isDigit(i-1)) {
                    return 0;
                }
                if (!Character.isDigit(A.charAt(i+1)) && A.charAt(i+1) != '+' && A.charAt(i+1)
                        != '-' && A.charAt(i+1) != '.') {
                    return 0;
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(isNumber("0.1"));
    }
}
