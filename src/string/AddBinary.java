package string;

public class AddBinary {

    public static String addBinary(String A, String B) {
        StringBuilder builder = new StringBuilder();
        int n = A.length()-1;
        int m = B.length()-1;
        // if (B.length() < A.length()) {
        //     n = B.length()-1;
        //     m = A.length()-1;

        // }
        int r = 0;
        while (n>=0 || m>=0) {
            int a = n>=0 ? Integer.parseInt(String.valueOf(A.charAt(n))) : 0;
            int b = m>=0 ? Integer.parseInt(String.valueOf(B.charAt(m))) : 0;

            int i = a ^ b ^ r;
            if (a +b+r >=2) {
                r = 1;
            } else {
                r = 0;
            }
            builder.append(i);
            m--;
            n--;
        }
        if (n>=0) {
            for(int i = n; i>=0; i--) {
                builder.append(A.charAt(i));
            }
        } else {
            for(int i = m; i>=0; i--) {
                builder.append(B.charAt(i));
            }
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1010110111001101101000", "1000011011000000111100110"));
    }
}
