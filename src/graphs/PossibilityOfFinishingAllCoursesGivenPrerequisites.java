package graphs;

import sun.plugin.javascript.navig.Link;

import java.util.*;

public class PossibilityOfFinishingAllCoursesGivenPrerequisites {

    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {

        int[] roots = new int[A+1];

        if (B.size() == 0 || C.size() == 0) {
            return 1;
        }
        for (int i = 0; i < A+1; i++) {
            roots[i] = i;
        }

        for (int i = 0; i < B.size(); i++) {
            if (findRoot(B.get(i), roots) != findRoot(C.get(i), roots)) {
                union(B.get(i), C.get(i), roots);
            } else return 0;
        }

        return 1;

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

    public int solveTopoSort(int A, ArrayList<Integer> B, ArrayList<Integer> C) {

        int pre[] = new int[A+1];

        for (int i = 0; i < C.size(); i++) {
            pre[C.get(i)]++;
        }


        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < B.size(); i++) {

            ArrayList<Integer> orDefault = map.getOrDefault(B.get(i), new ArrayList<>());
            orDefault.add(C.get(i));
            map.put(B.get(i), orDefault);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < pre.length; i++) {
            if (pre[i] == 0) {
                q.add(i);
            }
        }
        if (q.isEmpty()) {
            return 0;
        }

        while(!q.isEmpty()) {
            int c = q.poll();
            for (int depending : map.getOrDefault(c, new ArrayList<>())) {
               pre[depending]--;
               if(pre[depending] == 0) {
                   q.add(depending);
               }
            }
        }

        for (int i = 0; i < pre.length; i++) {
            if (pre[i] != 0) {
                return 0;
            }
        }
        return 1;

    }


}
