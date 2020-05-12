package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class SmallestSequenceWithGivenPrimes {

    public ArrayList<Integer> solve(int A, int B, int C, int K) {
        TreeSet<Integer> q = new TreeSet<Integer>();
        q.add(1);
        ArrayList<Integer> result = new ArrayList<>();

        while(result.size()<K){

            Integer num = q.pollFirst();
            if (num!=1) {
                result.add(num);
            }
            if (result.size()>=K) break;
            q.add(num*A);
            q.add(num*B);
            q.add(num*C);

        }
        return result;
    }
}
