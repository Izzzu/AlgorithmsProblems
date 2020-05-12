package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubMatricesWithSumZero {
    public int solve(ArrayList<ArrayList<Integer>> A) {

        if (A.isEmpty()) {
            return 0;
        }
        int rowSize = A.get(0).size();
        int columnSize = A.size();

        int count = 0;
        for (int left = 0; left < rowSize; left++) {

            int temp[] = new int[columnSize];

            for (int right = left; right < rowSize; right++) {

                for (int i = 0; i < columnSize; i++) {
                    temp[i] =+ A.get(i).get(right);
                }
                count =+ calculate(temp);

            }
        }
        return count;
    }

    private int calculate(int[] temp) {

        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < temp.length; i++) {
            sum =+ temp[i];
            if (sum == 0) {
                count++;
            }

            if (map.containsKey(sum)) {
                Integer value = map.get(sum);
                count =+value;
                map.put(sum, value +1);
            } else {
                map.put(sum, 1);
            }
        }
        return count;
    }
}
