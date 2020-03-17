package dp;

import java.util.ArrayList;

public class MinJumpsArray {

    public int jump(ArrayList<Integer> A) {
        if (A.size()==0) {
            return 0;
        }
        if (A.size() == 1) {
            return 0;
        }
        if (A.get(0) == 0) {
            return -1;
        }
        int maxReach = A.get(0);
        int steps = A.get(0);
        int jumps = 1;

        for (int i = 1; i < A.size(); i++) {

            if (i == A.size()-1) {
                return jumps;
            }
            maxReach = Math.max(maxReach, A.get(i) + i);
            steps--;
            if (steps == 0) {
                jumps++;
                if (i>=maxReach) {
                    return -1;
                }
                steps = maxReach - i;
            }
        }

        return -1;
    }

}
