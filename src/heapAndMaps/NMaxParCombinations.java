package heapAndMaps;

import java.util.*;

public class NMaxParCombinations {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Collections.sort(A, Collections.reverseOrder());
        Collections.sort(B, Collections.reverseOrder());


        for (Integer i : A) {
            for (Integer j : B) {
                int sum = i+j;
                if (pq.size()<A.size()) {
                    pq.add(sum);
                } else {
                    if (pq.peek()<sum) {
                        pq.poll();
                        pq.add(sum);
                    } else
                        break;
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>(pq);
        Collections.sort(res, Collections.reverseOrder());
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new NMaxParCombinations().solve(new ArrayList<>(Arrays.asList(3, 2, 4, 2)), new ArrayList<>(Arrays.asList( 4, 3, 1, 2))));
    }

}
