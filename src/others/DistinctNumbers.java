package others;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DistinctNumbers {
    public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
        }

        return set.size();

    }
}
