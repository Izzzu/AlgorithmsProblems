package backtracking;

import java.util.*;

public class SubsetBinaryCounting {

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        // return getSubsets(A, 0);

        ArrayList<ArrayList<Integer>> powerSet = new ArrayList<>();
        for (int i = 0; i<(1<<A.size()); i++) {
            int bit = i;
            ArrayList<Integer> inputSet = new ArrayList<Integer>();
            while(bit!=0) {
                inputSet.add(A.get((int)((Math.log(bit&~(bit-1)))/Math.log(2))));
                bit &=bit-1;
            }
            powerSet.add(inputSet);
        }
        Collections.sort(powerSet, comp);
        return powerSet;
    }

    Comparator<ArrayList<Integer>> comp = (o1, o2) -> {
        Iterator<Integer> i1 = o1.iterator();
        Iterator<Integer> i2 = o2.iterator();
        int result;

        do {
            if (!i1.hasNext()) {
                if (!i2.hasNext()) return 0; else return -1;
            }
            if (!i2.hasNext()) {
                return 1;
            }

            result = i1.next().compareTo(i2.next());
        } while (result == 0);

        return result;
    };

}
