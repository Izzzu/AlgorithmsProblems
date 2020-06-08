package others;


import java.util.Arrays;

public class SmallestPositiveInteger {
    public int solution(int[] A) {

        if (A.length == 0) {
            return 1;
        }

        Arrays.sort(A);

        int start = 0;
        int end = A.length-1;

        while(start<end) {
            int mid = start + (end-start)/2;
            if (A[mid]<=0) {
                start = mid+1;
            } else if (A[mid]>0) {
                end = mid;
            }
        }

        if (A[start] == 1) {
            for (int i = start+1; i < A.length; i++) {
                if(A[i] > A[i-1]+1) {
                    return A[i-1] + 1;
                }
            }
        } else {
            return 1;
        }
        return A[A.length-1] +1;

    }

    public static void main(String[] args) {
        int [] arr = {-1, -2, -3, 5, 1};
        System.out.println(new SmallestPositiveInteger().solution(arr));
    }
}
