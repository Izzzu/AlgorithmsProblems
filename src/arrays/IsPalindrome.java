package arrays;

public class IsPalindrome {
    public static int isPalindrome(int A) {
        // String s = String.valueOf(A);
        // int i =0;
        // int k = s.length()-1;
        // while(i<k) {
        //     if (s.charAt(i) != s.charAt(k)) {
        //         return 0;
        //     }
        //     k--;
        //     i++;
        // }
        // return 1;

        int d =0;
        int k = 0;
        int n = A;
        while(n>1) {
            n= n/10;
            k++;
        }
        while(k>0) {
            if(A<10) {
                return 1;
            }
            int r = A%10;
            int floor = (int)Math.floor(A / (Math.pow(10, Math.max(k - 1, 1))));
            if (r!= floor) {
                return 0;
            } else {
                A = ((A%(int)Math.pow(10, k - 1))-r)/10;
                k = k-2;
            }
        }
        return 1;
    }

    public static int reverse(int A) {
        int sign = 1;
        if (A<0) {
            sign = -1;
        }
        if (A == Integer.MIN_VALUE) {
            return 0;
        }
        return sign*rev(Math.abs(A));
    }

    public static int rev(int A) {
        int n = A;
        int rev = 0;
        while(n>0) {
            if (rev> (Integer.MAX_VALUE - n%10)/10) {
                return 0;
            }
            rev = rev*10 + n%10;
            n /=10;

        }
        return rev;
    }



    public static void main(String[] args) {
        System.out.println(reverse(-1234567891));

    }
}
