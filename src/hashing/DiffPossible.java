package hashing;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DiffPossible {

    public int diffPossible(final List<Integer> A, int B) {
        Set<Integer> hash = new HashSet<>();
        for (int i = 0; i < A.size(); i++) {
            if (hash.contains(B+A.get(i)) || hash.contains(A.get(i)-B)) {
                return 1;
            }
            hash.add(A.get(i));
        }
        return 0;
    }
}
