package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class UnboundedKnapsack {

    public ArrayList<Integer> solve(int W, ArrayList<Integer> B) {

        int[] pointers = new int[W + 1];
        int[] values = new int[W + 1];
        for (int weight = 0; weight <= W; weight++) {
            for (int j = 0; j < B.size(); j++) {
                if (weight >= B.get(j) && values[weight - B.get(j)] + 1> values[weight]) {
                    values[weight] = values[weight - B.get(j)] + 1;
                    pointers[weight] = j;
                }
            }
        }

        int wgth = W;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while ((wgth >= 0) && ((wgth - B.get(pointers[wgth])) >= 0)) {
            ans.add( pointers[wgth]);
            wgth = wgth - B.get(pointers[wgth]);
        }
        return ans;
    }

    //greedy
    public ArrayList<Integer> solve2(int A, ArrayList<Integer> B) {
        ArrayList<Integer> resp = new ArrayList<>();
        int min = Collections.min(B);
        int available = A % min;

        int i = 0;
        while (resp.size() < A / min) {
            if (B.get(i) - min <= available) {
                available -= B.get(i) - min;
                resp.add(i);
            } else {
                i++;
            }
        }
        return resp;
    }

    public static void main(String[] args) {
        System.out.println(new UnboundedKnapsack().solve(10, new ArrayList<>(Arrays.asList(8, 8, 6, 5, 4 ))));
    }

}
