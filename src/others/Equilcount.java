package others;

import java.util.Arrays;

public class Equilcount {
    public int solution(int[] A) {
        if (A.length <=1 ) {
            return 0;
        }

        int candidate = A[0];
        int canSize = 0;
        for (int i = 0; i < A.length; i++) {
            if (canSize == 0) {
            canSize++;
            candidate = A[i];
            } else if (A[i] == candidate){
                canSize++;
            } else {
                canSize--;
            }
        }

        if (canSize<=0) {
            return 0;
        }
        final int c = candidate;
        long count = Arrays.stream(A)
                .filter(i -> i == c)
                .count();

        if (count<=A.length/2) {
            return 0;
        }

        int leader = candidate;

        int leaderCount = 0;
        int result = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == leader) {
                leaderCount++;
            }

            if (leaderCount>(i+1)/2 && (count-leaderCount)>(A.length-i-1)/2) {
                result++;
            }
        }

        return result;


    }

    public static void main(String[] args) {
        int [] arr = {4, 3, 4, 4, 4, 2};
        System.out.println(new Equilcount().solution(arr));
    }

}
