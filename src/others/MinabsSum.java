package others;

import java.util.Arrays;

public class MinabsSum {
    public int solution(int[] A) {

        if (A.length == 0) {
            return 0;
        }

        for (int i = 0; i < A.length; i++) {
            A[i] = Math.abs(A[i]);
        }
        int sum = Arrays.stream(A)
                .sum();
        Integer dp[][] = new Integer[A.length][sum+1];
        return findMinDiff(A, 0, 0, 0,dp);
    }

    private int findMinDiff(int[] a, int index, int sum1, int sum2, Integer[][] dp) {

        if (index == a.length) {
            return Math.abs(sum1-sum2);
        }

        if (dp[index][sum1] == null) {
            int diff1 = findMinDiff(a, index+1, sum1+a[index], sum2, dp);
            int diff2 = findMinDiff(a, index+1, sum1, sum2+a[index], dp);

            dp[index][sum1] = Math.min(diff1, diff2);
        }

        return dp[index][sum1];

    }
    public int solution2(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        for (int i = 0; i < A.length; i++) {
            A[i] = Math.abs(A[i]);
        }
        int sum = Arrays.stream(A)
                .sum();
        boolean dp[][] = new boolean[A.length][sum/2+1];
        for (int i = 0; i < A.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < sum/2+1; i++) {
            dp[0][i] = A[0] == i ? true : false;
        }


        for (int i = 1; i < A.length; i++) {
            for (int s = 1; s <= sum / 2; s++) {
                if (dp[i-1][s]) {
                    dp[i][s] = true;
                } else {
                    if (s>=A[i]) {
                        dp[i][s] = dp[i-1][s-A[i]];
                    }
                }
            }
        }

        int sum1 = 0;
        for (int i = dp[A.length - 1].length-1; i>=0; i--) {
            if (dp[A.length-1][i]) {
                sum1 = i;
                break;
            }
        }

        return Math.abs(sum1- (sum-sum1));


    }

    //not mine
    public int solution3(int[] A) {
        int arrayLength = A.length;
        int M = 0;
        for (int i = 0; i < arrayLength; i++) {
            A[i] = Math.abs(A[i]);
            M = Math.max(A[i], M);
        }

        int S = Arrays.stream(A)
                .sum();
        int[] dp = new int[S + 1];
        int[] count = new int[M + 1];
        for (int i = 0; i < arrayLength; i++) {
            count[A[i]] += 1;
        }
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i < M + 1; i++) {
            if (count[i] > 0) {
                for(int j = 0; j < S; j++) {
                    if (dp[j] >= 0) {
                        dp[j] = count[i];
                    } else if (j >= i && dp[j - i] > 0) {
                        dp[j] = dp[j - i] - 1;
                    }
                }
            }
        }
        int result = S;
        for (int i = 0; i < Math.floor(S / 2) + 1; i++) {
            if (dp[i] >= 0) {
                result = Math.min(result, S - 2 * i);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int [] arr = {1, 5, 2, -2};
        System.out.println(new MinabsSum().solution(arr));
    }


}
