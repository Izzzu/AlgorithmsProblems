package dp;

public class Stairs {

    int[] memo = new int[37];
    public int climbStairs(int A) {

        if(memo[A] != 0) {
            return memo[A];
        }

        if (A <= 1) {
            memo[A] = 1;
            return 1;
        } else if (A==2) {
            memo[A] = 2;
            return 2;
        } else {
            memo[A-2] = climbStairs(A-2);
            memo[A-1] = climbStairs(A-1);
            return memo[A-2] + memo[A-1];
        }
    }





}
