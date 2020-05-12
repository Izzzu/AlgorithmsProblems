package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RodCutting {
    public int rodCut(int A, ArrayList<Integer> B) {
        ArrayList<Integer> currentSolution = new ArrayList<Integer> ();
         ArrayList<Integer> points = new ArrayList<Integer> ();
        for (int i = 1; i <= A; i++) {
            points.add(i);
        }

        int i = rodCutRec(A, B, 0, A - 1, 0, points, currentSolution, new ArrayList<>());
        System.out.println(currentSolution);
        return i;
    }

    private int rodCutRec(int a, ArrayList<Integer> b, int startInc, int endInk, int prevCost, ArrayList<Integer> points,
                                         ArrayList<Integer> currentSolution, List<Integer> solution) {

        if (b.isEmpty()) {

            return prevCost;
        }
        int currCost = Integer.MAX_VALUE;
        if (endInk == startInc) {
            return currCost;
        }
        for (int i = 0; i < b.size(); i++) {
            int point = b.get(i);
            if (point>points.get(endInk) || point<points.get(startInc)) {
                continue;
            }
            b.remove(i);

           currentSolution.add(point);
            int i1 = rodCutRec(point - startInc, b, startInc, i, prevCost + a, points, currentSolution, solution);
            int i2 = rodCutRec(endInk+1 - point, b, i, endInk, prevCost + a, points, currentSolution, solution);


            int min = Math.min(i1, i2);
            if (min<currCost) {

                currCost = min;
                if (b.isEmpty()) {
                    System.out.println(currentSolution + " = " + currCost);

                }
            }
            b.add(i, point);
            currentSolution.remove(currentSolution.size()-1);




        }

        return currCost;
    }


    public static void main(String[] args) {
        System.out.println(new RodCutting().rodCut(6, new ArrayList<>(Arrays.asList(1, 2, 5))));
    }
}
