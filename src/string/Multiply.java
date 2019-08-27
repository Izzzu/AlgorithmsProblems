package string;

public class Multiply {
    public static  String multiply(String A, String B) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int[] result = new int[B.length() + A.length()];

        if (a.length == 0|| b.length == 0) {
            return "0";
        }
        int indA = 0;
        int indB = 0;
        for (int i = b.length-1; i>=0; i--) {
            int carry = 0;
            int n1 = b[i] - '0';

            indA = 0;
            for (int j = a.length-1; j>=0; j--) {
                int n2 = a[j] -'0';
                int sum = n1*n2 + carry + result[indA + indB];
                carry = sum/10;
                result[indA + indB] = sum%10;
                indA++;
            }
            result[indA + indB] += carry;
            indB++;

        }
        int i = result.length -1;
        while(i>=0 && result[i] ==0) i--;
        if (i == -1) return "0";

        StringBuilder s = new StringBuilder();

        while(i>=0)
            s.append(result[i--]);

        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("10", "20"));
    }
}
