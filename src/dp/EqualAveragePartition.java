package dp;

import java.util.*;

public class EqualAveragePartition {
    public ArrayList<ArrayList<Integer>> avgset(ArrayList<Integer> A) {

        Collections.sort(A);
        ArrayList<ArrayList<Integer>> result = new  ArrayList<ArrayList<Integer>>();
        int n = A.size();
        int sum = A.stream().reduce(Integer::sum).orElse(0);
        // sum/n = sum1/k
        for (int s = 1; s < sum; s++) {
            if (s*n%sum!= 0) {
                continue;
            }
            int k = s*n/sum;
            ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
            findSubset(s, 0, k, A, new ArrayList<>(), subsets, 0);
            Collections.sort(subsets, new ListComparator<>());
            ArrayList<Integer> subset = (subsets.isEmpty()) ? new ArrayList<>() : subsets.get(0);

            if (!subset.isEmpty()) {
                result.add(subset);

                ArrayList<Integer> subset2 = getDifference(A, subset);
                result.add(subset2);
                return result;
            }
        }
        return result;
    }

    private ArrayList<Integer> getDifference(List<Integer> A, List<Integer> subset) {
        ArrayList<Integer> subset2 = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        while (i<subset.size() && j<A.size()) {
            if (A.get(j) == subset.get(i)) {
                i++;
                j++;
            } else {
                subset2.add(A.get(j));
                j++;
            }
        }
        while(j<A.size()) {
            subset2.add(A.get(j));
            j++;
        }
        return subset2;
    }

    private void findSubset(int target, int sumSoFar, int targetSize, ArrayList<Integer> A, ArrayList<Integer> temp,
                            ArrayList<ArrayList<Integer>> res, int ind) {

        if (ind >= A.size()) {
            if (sumSoFar == target && targetSize == temp.size()) {
                if (!res.contains(temp)) {
                    res.add(new ArrayList<Integer>(temp));
                }

            }
            return;
        }

        findSubset(target, sumSoFar, targetSize, A, temp, res, ind+1);
        temp.add(A.get(ind));
        findSubset(target, sumSoFar + A.get(ind), targetSize, A, temp, res, ind+1);
        temp.remove(A.get(ind));

    }

    static class ListComparator<T extends Comparable<T>> implements Comparator<List<T>> {

        @Override
        public int compare(List<T> o1, List<T> o2) {
            int size = Integer.compare(o1.size(), o2.size());
            if (size!=0) {
                return size;
            }
            for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
                int c = o1.get(i).compareTo(o2.get(i));
                if (c != 0) {
                    return c;
                }
            }
            return size;
        }

    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        List<Integer> list = Arrays.asList(47, 14, 30, 19, 30, 4, 32, 32, 15, 2, 6, 24);
        Collections.sort(list);
        new EqualAveragePartition().findSubset(85, 0, 4, new ArrayList(list), new ArrayList<>(), res, 0);
        Collections.sort(res, new ListComparator<>());
        System.out.println(res);

        List<Integer> A = Arrays.asList(47, 14, 30, 19, 30, 4, 32, 32, 15, 2, 6, 24);
        Collections.sort(A);
        List<Integer> sub = Arrays.asList(9, 15);
        System.out.println(new EqualAveragePartition().avgset(new ArrayList<>(A)));
    }

}
