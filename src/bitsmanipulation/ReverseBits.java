package bitsmanipulation;

public class ReverseBits {
    public static long reverse(long a) {
        long length = 32;
        long result = 0;

        for (long i = 0; i<length; i++) {
            long temp = a&(1L<<i);
            if (temp!=0) {
                result = result | (1L<<(length-1L-i));
            }
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(reverse(0));
    }
}
