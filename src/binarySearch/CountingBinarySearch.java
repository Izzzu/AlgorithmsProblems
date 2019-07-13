package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountingBinarySearch {
    public static int findCount(final List<Integer> A, int B) {

        int first = find(A, B, true);
        int last = find(A, B, false);
        if (first==-1 && last == -1) {
            return 0;
        }
        return last-first+1;

    }

    public static int find(final List<Integer> A, int B, boolean searchFirst) {
        int low = 0, high = A.size()-1;
        int result = -1;
        while (low<=high) {
            int mid = (low+high)/2;
            if (A.get(mid) == B) {
                if (searchFirst) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
                result = mid;
            } else if (A.get(mid)>B) {
                high = mid-1;
            } else {
                low = mid+1;
            }

        }
        return result;

    }
    public static void main(String[] args) {
        int k = findCount(new ArrayList<Integer>(Arrays.asList( 1, 1, 2, 2, 2, 2, 3, 3,
                3, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 7, 7, 8, 8, 8, 8, 9, 9, 10, 10, 10 )), 1);
        System.out.println(k);
    }
}
