package greedy;

import java.util.ArrayList;
import java.util.Collections;

public class MiceHoles {

    public int mice(ArrayList<Integer> A, ArrayList<Integer> B) {
        Collections.sort(A);
        Collections.sort(B);
        int min = 0;
        for (int i = 0; i < A.size(); i++) {
            min = Math.max(Math.abs(A.get(i)-B.get(i)), min);
        }

        return min;
    }

}
