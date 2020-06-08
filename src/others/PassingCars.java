package others;

public class PassingCars {
    public int solution(int[] A) {
        int i = 0;
        long count = 0;
        int zeros = 0;
        while(i<A.length) {
            if (A[i] == 0) {

                zeros++;
                i++;
                int ones = 0;
                while(i<A.length && A[i] == 1) {
                    ones++;
                    i++;
                }
                count += ((long)zeros*(long)ones);
                if (count>1000000000L) {
                    return -1;
                }
            } else {
                i++;
            }
        }
        return (int)count;
    }
}
