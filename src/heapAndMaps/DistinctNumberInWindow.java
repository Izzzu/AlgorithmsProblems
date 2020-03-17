package heapAndMaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DistinctNumberInWindow {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int k) {

        Map<Integer, Integer> hash = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            if (i>=k-1) {
                Integer val = hash.getOrDefault(A.get(i), 0);
                hash.put(A.get(i), val+1);

                result.add(hash.size());

                if (hash.get(A.get(i-k+1)) == 1) {
                    hash.remove(A.get(i-k+1));
                } else {
                    Integer v = hash.get(A.get(i - k + 1));
                    hash.put(A.get(i-k+1), v-1);
                }

            } else {
                Integer val = hash.getOrDefault(A.get(i), 0);
                hash.put(A.get(i), val+1);
            }

        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(new DistinctNumberInWindow().dNums(new ArrayList<>(Arrays.asList( 1, 2, 1, 3, 4, 3)), 3));
    }
}
