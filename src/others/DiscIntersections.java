package others;

public class DiscIntersections {

    public int solution(int[] A) {

        int starts [] = new int[A.length];
        int ends [] = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            if (A[i]>i) starts[0]++;
            else starts[i-A[i]]++;
            if (((long)A[i]+(long)i)>=(long)A.length) ends[A.length-1]++;
            else ends[i+A[i]]++;
        }


        int current = 0;
        long sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += (long)current*(long)starts[i] + (long)starts[i]*(long)(starts[i]-1)/2L;
            if (sum>=10000000L) {
                return -1;
            }
            current += starts[i]-ends[i];
        }

        return (int)sum;
    }
}
