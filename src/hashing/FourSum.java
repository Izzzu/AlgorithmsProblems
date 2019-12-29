package hashing;

import java.util.*;

public class FourSum {

    class Pair {
        public int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        Set<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
        Map<Integer, Set<Pair>> map = new HashMap<>();

        for (int i = 0; i < A.size(); i++){
            for (int j = i+1; j < A.size(); j++) {
                int sum = A.get(i) + A.get(j);

                if (map.containsKey(B-sum)) {
                    Set<Pair> pairs = map.get(B-sum);
                    for (Pair pair : pairs) {
                        if (i != pair.x && i!= pair.y && j != pair.x && j != pair.y) {
                            ArrayList<Integer> list = new ArrayList<>(Arrays.asList(A.get(pair.x), A.get(pair.y), A.get(i), A.get(j)));
                            Collections.sort(list);
                            result.add(list);
                        }
                    }
                }

                Set<Pair> pairs = map.getOrDefault(sum, new HashSet<>());
                pairs.add(new Pair(i, j));
                map.put(sum, pairs);
            }
        }

        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>(result);
        Collections.sort(arrayLists, (o1, o2) -> {
            if (o1.size()<o2.size()) {
                return -1;
            }
            if (o2.size()<o1.size()) {
                return 1;
            }
            for (int i = 0; i < o1.size(); i++) {
                if (o1.get(i)<o2.get(i)) {
                    return -1;
                }
                if (o1.get(i)>o2.get(i)) {
                    return 1;
                }
            }
            return 0;
        });
        return arrayLists;
    }


    public static void main(String[] args) {
        System.out.println(new FourSum().fourSum(new ArrayList<>(Arrays.asList(1, 0 ,-1, 0, -2, 2)), 0));
    }
}
