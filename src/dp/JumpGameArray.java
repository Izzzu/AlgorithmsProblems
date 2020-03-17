package dp;

import java.util.ArrayList;

public class JumpGameArray {
    public int canJump(ArrayList<Integer> A) {

        if (A.isEmpty()) {
            return 0;
        }

        int reach = 0;
        for (int i = 0; i < A.size(); i++) {
            if (i<=reach) {
                reach = Math.max(reach, i+A.get(i));
            } else
                break;
        }

        if (reach>=A.size())
            return 1;
        else
            return 0;
    }
}
