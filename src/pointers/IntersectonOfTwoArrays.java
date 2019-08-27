package pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectonOfTwoArrays {

    public static ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int p1 = 0;
        int p2=0;
        while(p1<A.size() && p2<B.size()) {
            if (A.get(p1).equals(B.get(p2))) {
                result.add(A.get(p1));
                p1++;
                p2++;
            } else if (A.get(p1)>B.get(p2)) {
                p2++;
            } else {
                p1++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(intersect(Arrays.asList(10000000), Arrays.asList(10000000)));

    }
}
