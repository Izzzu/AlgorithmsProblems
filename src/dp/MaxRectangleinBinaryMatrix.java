package dp;

import java.util.ArrayList;
import java.util.Stack;

// not working
public class MaxRectangleinBinaryMatrix {
    public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {

        if(A.isEmpty()) {
            return 0;
        }
        int maxRectangle = 0;
        maxRectangle = Math.max(maxRec(A.get(0)), maxRectangle);
        for (int i = 1; i < A.size(); i++) {
            ArrayList<Integer> row = A.get(i);
            for (int j = 0; j < A.get(i).size(); j++) {
                if (A.get(i).get(j) != 0) {
                    row.set(j, A.get(i).get(j) + A.get(i-1).get(j));
                } else {
                    row.set(j, A.get(i).get(j));
                }
            }
            A.set(i, row);
            int maxLocal = maxRec(row);
            maxRectangle = Math.max(maxLocal, maxRectangle);
        }
        return maxRectangle;
    }

    private int maxRec(ArrayList<Integer> row) {
        Stack<Integer> S = new Stack<>();
        int i = 0, n = row.size();
        int max = 0;
        while(i<n) {
            if (S.isEmpty() || row.get(i)>=row.get(S.peek())) {
                S.push(i);
                i++;
            } else {
                int currentIndex = S.pop();
                if (S.isEmpty()) {
                    max = Math.max(max, row.get(currentIndex)*i);
                } else {
                    max = Math.max(max, row.get(currentIndex)*(i-1-S.peek()));
                }
            }
        }
        while(!S.isEmpty()) {
            int currentIndex = S.pop();
            if (S.isEmpty()) {
                max = Math.max(max, row.get(currentIndex)*i);
            } else {
                max = Math.max(max, row.get(currentIndex)*(i-1-S.peek()));
            }
        }
        return max;
    }
}
