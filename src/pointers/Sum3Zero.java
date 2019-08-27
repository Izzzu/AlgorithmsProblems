package pointers;

import java.util.*;

public class Sum3Zero {
    public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {

        Collections.sort(A);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        for (int i = 0; i<A.size()-1; i++) {
            int l = i+1;
            int r = A.size()-1;
            int k = A.get(i);

            while(l<r) {
                long sum = k + A.get(l) + A.get(r);
                if (sum == 0) {
                    set.add(new ArrayList(Arrays.asList(k, A.get(l), A.get(r))));
                    l++;
                    r--;

                }
                 else if (sum >0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        res.addAll(set);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new ArrayList<>(Arrays.asList(1, 4, 4, 1, 0, -1, -4, -1, -1, -1, 1, -4, -4, -3, 3, -2, 0, 2, -5, -4, -5, -2))));
    }
}
