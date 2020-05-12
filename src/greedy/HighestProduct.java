package greedy;

import java.util.ArrayList;
import java.util.Collections;

public class HighestProduct {



    public int maxp3(ArrayList<Integer> A) {


        int res = 1;
        if (A.size()<=3) {
            for (int i = 0; i < A.size(); i++) {
                res *= A.get(i);
            }
            return res;
        }
        Collections.sort(A);
        int a = A.get(0)*A.get(1)*A.get(A.size()-1);
        int b = A.get(A.size()-1) * A.get(A.size()-2) * A.get(A.size() - 3);

        return Math.max(a, b);
    }
}
