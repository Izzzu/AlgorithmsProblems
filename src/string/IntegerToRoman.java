package string;

public class IntegerToRoman {

    public static String intToRoman(int A) {

        StringBuilder b = new StringBuilder();
        while (A > 0) {
            if (A >= 1000) {
                int a = A;
                int n = a / 1000;
                a = a - a / 1000 * 1000;
                for (int i = 0; i < n; i++) {
                    b.append('M');
                }
                A = a;
            } else if (A >= 900) {
                int n = A / 900;
                A = A - A / 900 * 900;
                for (int i = 0; i < n; i++) {
                    b.append("CM");
                }
            } else if (A >= 500) {
                int n = A / 500;
                A = A - A / 500 * 500;
                for (int i = 0; i < n; i++) {
                    b.append("D");
                }
            } else if (A >= 400) {
                int n = A / 400;
                A = A - A / 400 * 400;
                for (int i = 0; i < n; i++) {
                    b.append("CD");
                }
            } else if (A >= 100) {
                int n = A / 100;
                A = A - A / 100 * 100;
                for (int i = 0; i < n; i++) {
                    b.append("C");
                }
            } else if (A >= 90) {
                int n = A / 90;
                A = A - A / 90 * 90;
                for (int i = 0; i < n; i++) {
                    b.append("XC");
                }
            } else if (A >= 50) {
                int n = A / 50;
                A = A - A / 50 * 50;
                for (int i = 0; i < n; i++) {
                    b.append("L");
                }
            } else if (A >= 40) {
                int n = A / 40;
                A = A - A / 40 * 40;
                for (int i = 0; i < n; i++) {
                    b.append("XL");
                }
            } else if (A >= 10) {
                int n = A / 10;
                A = A - A / 10 * 10;
                for (int i = 0; i < n; i++) {
                    b.append("X");
                }
            } else if (A >= 9) {
                int n = A / 9;
                A = A - A / 9 * 9;
                for (int i = 0; i < n; i++) {
                    b.append("IX");
                }
            } else if (A >= 5) {
                int n = A / 5;
                A = A - A / 5 * 5;
                for (int i = 0; i < n; i++) {
                    b.append("V");
                }
            } else if (A >= 4) {
                int n = A / 4;
                A = A - A / 4 * 4;
                for (int i = 0; i < n; i++) {
                    b.append("IV");
                }
            } else {
                int n = A / 1;
                A = A - A / 1 * 1;
                for (int i = 0; i < n; i++) {
                    b.append("I");
                }
            }
        }


        return b.toString();
    }

    private static int getA(int A, StringBuilder b, int q, char m) {
        int n = A / q;
        A = A - A / q * q;
        for (int i = 0; i < n; i++) {
            b.append(m);
        }
        return A;
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(14));
    }
}
