package others;

public class NumberSolitaire {
    public int solution(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        //int dp[][] = new int[]
        return solution(A, 0, A[0]);
    }

    private int solution(int[] a, int start, int current) {
        if (start==a.length-1) {
            return current;
        }
        int a1 = start+1>=a.length ? Integer.MIN_VALUE : solution(a, start+1, current+a[start+1]);
        int a2 = start+2>=a.length ? Integer.MIN_VALUE : solution(a, start+2, current+a[start+2]);
        int a3 = start+3>=a.length ? Integer.MIN_VALUE : solution(a, start+3, current+a[start+3]);
        int a4 = start+4>=a.length ? Integer.MIN_VALUE : solution(a, start+4, current+a[start+4]);
        int a5 = start+5>=a.length ? Integer.MIN_VALUE : solution(a, start+5, current+a[start+5]);
        int a6 = start+6>=a.length ? Integer.MIN_VALUE : solution(a, start+6, current+a[start+6]);

        return Math.max(Math.max(Math.max(Math.max(Math.max(a1, a2), a3), a4), a5), a6);
    }

    public int solution2(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int dp[] = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                dp[0] = A[0];
            } else {
                int max = Integer.MIN_VALUE;
                for (int j = 1; j <= 6; j++) {
                    if (i-j>=0) {
                        max = Math.max(dp[i-j], max);
                    }
                }
                dp[i] = max + A[i];
            }


        }

        return dp[A.length-1];
    }

}
