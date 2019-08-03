package bitsmanipulation;

public class Dividend {
    public static int divide(int A, int B) {
        if (A == 0) {
            return 0;
        }
        if (B == 0) {
            throw new RuntimeException();
        }
        int sign = (A<0) ^ (B<0) ? -1 : 1;
        long dividend = Math.abs((long)A);
        long divisor = Math.abs((long)B);

        long quotient = 0, temp = 0;

        for (long i = 31L; i>=0; i--) {
            if(temp+(divisor<<i)<=dividend) {
                temp += divisor<<i;
                quotient |= 1L<<i;
            }
        }
        if (quotient*(long)sign>Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return sign*(int)quotient;
    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -1));
    }
}
