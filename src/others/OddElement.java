package others;

import java.util.HashSet;
import java.util.Set;

public class OddElement {

    public int solution(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (!set.remove(A[i])) {
                set.add(A[i]);
            }
        }

        return set.iterator().next();

    }

}
