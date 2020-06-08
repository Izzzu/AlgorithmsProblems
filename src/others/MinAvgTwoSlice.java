package others;

public class MinAvgTwoSlice {

    public int solution(int[] A) {

        if (A.length<2) {
            return -1;
        }
        int minSlice2 = A[0] + A[1];
        int min2Ind = 0;

        int minSlice3 = Integer.MAX_VALUE;
        int min3Ind = 0;

        for (int i = 2; i <A.length; i++) {

            int slice2 = A[i] + A[i-1];
            if (slice2 < minSlice2) {
                minSlice2 = slice2;
                min2Ind = i-1;
            }

            int slice3 = slice2 + A[i-2];
            if (slice3 < minSlice3) {
                minSlice3 = slice3;
                min3Ind = i-2;
            }
        }

        long s1 = minSlice2*3;
        long s2 = minSlice3*2;

        if (s1==s2) {
            return Math.min(min2Ind, min3Ind);
        }
        if (s1<s2) {
            return min2Ind;
        }
        return min3Ind;
    }

}
