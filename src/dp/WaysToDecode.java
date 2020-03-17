package dp;

public class WaysToDecode {
    public int numDecodings(String A) {

//        if (A.length() == 0) {
//            return 1;
//        }
//        int sum = 0;
//        if (A.length()>=1 && A.charAt(0) - '0' >=1 && A.charAt(0) - '0' <= 9) {
//            sum = numDecodings(A.substring(1));
//        }
//
//        if (A.length()>=2 && ((A.charAt(0) - '0' == 1 && A.charAt(1)-'0' >=0 && A.charAt(1)-'0' <=9) || (A.charAt(0) - '0' == 2 && A.charAt(1)-'0'>=0 && A.charAt(1)-'0'<=6))) {
//            sum += numDecodings(A.substring(2));
//        }
//
//        return sum;
        int[] dp = new int[A.length()+1];
        for (int i = 0; i <= A.length(); i++) {
            dp[i] = -1;
        }
        return numDecodings(A, 0, dp);
        


    }

    public int numDecodings(String A, int ind, int[] dp) {

        if (A.length() == ind) {
            return 1;
        }
        int sum = 0;
        if (A.length()>ind && A.charAt(ind) - '0' >=1 && A.charAt(ind) - '0' <= 9) {
            if (dp[ind+1]==-1) {
                dp[ind+1] = numDecodings(A, ind+1, dp);
            }
            sum = dp[ind+1];
        }

        if (A.length()>ind+1 && ((A.charAt(ind) - '0' == 1 && A.charAt(ind+1)-'0' >=0 && A.charAt(ind)-'0' <=9)
                || (A.charAt(ind) - '0' == 2 && A.charAt(ind+1)-'0'>=0 && A.charAt(ind+1)-'0'<=6))) {
            if (dp[ind+2]==-1) {
                dp[ind+2] = numDecodings(A, ind+2, dp);
            }
            sum += dp[ind+2];
        }

        return sum;

    }



    public static void main(String[] args) {
        System.out.println(new WaysToDecode().numDecodings("2611055971756562"));
    }
}
