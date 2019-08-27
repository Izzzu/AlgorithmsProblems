package string;

import java.math.BigInteger;

public class PowerOfTwo {

    public static int power(String A) {

//        char[] num = A.toCharArray();
//        int n = A.length();
//        int last = A.length()-1;
//        int r = 0;
//
//        if (n==1 && ( num[n-1] - '0')%2 != 0) {
//            return 0;
//        }
//
//        while(n!=1 || num[n-1] != '1') {
//            if(( num[n-1] - '0')%2 != 0) {
//                return 0;
//            }
//            int ind = 0;
//            for (int i = 0; i<n; i++) {
//                r = r*10 + (int)num[i] - (int)'0';
//                if (r<2) {
//                    if (i!=0) {
//                        num[ind++] = '0';
//                    }
//                    continue;
//                }
//                num[ind++] = (char)((int)(r/2) + (int)'0');
//                r = r - (r/2)*2;
//            }
//            n = ind;
//        }
//        return 1;

        if(A.equals("0")||A.equals("1"))return 0;
        BigInteger l=new BigInteger(A);

        if(l.bitCount()==1)return 1;
        else return 0;
    }


    public static void main(String[] args) {
        System.out.println(power("800"));
        //System.out.println(new BigInteger("7").bitCount());
    }
}
