package arrays;

public class TrailingZeros {

    public static int trailingZeroes(int A) {
        int sum = 0;
        int p = 5;
        while(p<=A) {
            sum = sum+ (int)Math.floor(A/p);
            p = p*5;
        }
        return sum;
    }

    public static void main(String[] args) {
        int k = trailingZeroes(9247);
        System.out.println(k);
    }
}
