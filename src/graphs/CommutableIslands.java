package graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CommutableIslands {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {

        int[] roots = new int[A+1];

        for (int i = 0; i < A+1; i++) {
            roots[i] = i;
        }
        PriorityQueue<ArrayList<Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.get(2)));
        for (ArrayList<Integer> list : B) {
            queue.offer(list);
        }

        int minCost = 0;

        while(!queue.isEmpty()) {
            ArrayList<Integer> list = queue.poll();
            int x = list.get(0);
            int y = list.get(1);
            int cost = list.get(2);
            if (findRoot(x, roots)!=findRoot(y, roots)) {
                minCost += cost;
                union(x, y, roots);
            }
        }

        return minCost;

    }

    private void union(int x, int y, int[] roots) {
        int rX = findRoot(x, roots);
        int rY = findRoot(y, roots);

        roots[rY] = rX;
    }

    private int findRoot(int y, int[] roots) {
        while (roots[y]!= y) {
            y = roots[y];
        }
        return y;
    }
}
