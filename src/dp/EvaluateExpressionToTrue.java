package dp;

public class EvaluateExpressionToTrue {

    static int MOD = 1003;
    public int cnttrue(String A) {
        char arr[] = A.toCharArray();

        int dp[][][] = new int[151][151][2];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                dp[i][j][1] = -1;
                dp[i][j][0] = -1;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'T') {
                dp[i][i][1] = 1;
                dp[i][i][0] = 0;
            } else if (arr[i] == 'F') {
                dp[i][i][1] = 0;
                dp[i][i][0] = 1;
            }
        }

        return evaluate(arr, 0, arr.length-1, 1, dp);
    }

    /*
    '|' will represent or operator
    '&' will represent and operator
    '^' will represent xor operator
    'T' will represent true operand
    'F' will false
     */
    private int evaluate(char[] arr, int start, int end, int output, int[][][] dp) {

        if (dp[start][end][output] != -1) {
            return dp[start][end][output];
        }
        long sum = 0;
        long ans = 0;
        for (int i = start; i <= end; i++) {
            if (output ==1) {
                if (arr[i] == '&') {
                    ans = (evaluate(arr, start, i-1, 1, dp)%MOD*evaluate(arr, i+1, end, 1, dp)%MOD)%MOD;
                    sum = (ans + sum)%MOD;
                } else if (arr[i] == '|') {
                    ans = (evaluate(arr, start, i-1, 1, dp)%MOD*evaluate(arr, i+1, end, 1, dp)%MOD
                            + evaluate(arr, start, i-1, 0, dp)%MOD*evaluate(arr, i+1, end, 1, dp)%MOD
                            + evaluate(arr, start, i-1, 1, dp)%MOD*evaluate(arr, i+1, end, 0, dp)%MOD)%MOD;
                    sum = (ans + sum)%MOD;

                } else if (arr[i] == '^') {
                    ans = (evaluate(arr, start, i-1, 1, dp)%MOD*evaluate(arr, i+1, end, 0 , dp)%MOD
                    + evaluate(arr, start, i-1, 0, dp)%MOD*evaluate(arr, i+1, end, 1, dp)%MOD)%MOD;
                    sum = (ans + sum)%MOD;


                }
            } else if (output == 0) {
                if (arr[i] == '&') {
                    ans = (evaluate(arr, start, i-1, 0, dp)%MOD*evaluate(arr, i+1, end, 0, dp)%MOD
                            + evaluate(arr, start, i-1, 0, dp)%MOD*evaluate(arr, i+1, end, 1, dp)%MOD
                            + evaluate(arr, start, i-1, 1, dp)%MOD*evaluate(arr, i+1, end, 0, dp)%MOD)%MOD;
                    sum = (ans + sum)%MOD;

                } else if (arr[i] == '|') {
                    ans = (evaluate(arr, start, i-1, 0, dp)%MOD*evaluate(arr, i+1, end, 0, dp)%MOD)%MOD;
                    sum = (ans + sum)%MOD;

                } else if (arr[i] == '^') {
                    ans = (evaluate(arr, start, i-1, 1, dp)%MOD*evaluate(arr, i+1, end, 1, dp)%MOD
                            + evaluate(arr, start, i-1, 0, dp)%MOD*evaluate(arr, i+1, end, 0, dp)%MOD)%MOD;
                    sum = (ans + sum)%MOD;


                }
            }
        }
        dp[start][end][output] = (int)sum;
        return dp[start][end][output];
    }

}
