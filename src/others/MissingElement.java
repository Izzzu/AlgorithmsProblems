package others;

public class MissingElement {
    public int solution(int[] A) {
        int start = 1;
        int end = A.length+1;

        long sum = ((long)end + (long)start)*((long)A.length+1)/2L;

        long realSum = 0;
        for (int i = 0; i < A.length; i++) {
            realSum+=A[i];
        }

        return (int)(sum-realSum);
    }
}
