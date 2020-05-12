package greedy;

import java.util.ArrayList;
import java.util.List;

public class Seats {
    static int MOD = 10000003;
    public int seats(String A) {
        List<Integer> indexes = new ArrayList();

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'x') {
                indexes.add(i);
            }
        }

        long sum = 0;

        if (indexes.isEmpty()) {
            return 0;
        }

        int median = indexes.size()/2;
        int max = indexes.get(median);
        for (int i = median; i < indexes.size(); i++) {
            Integer index = indexes.get(i);
            if (index > max) {
                sum = (sum + (index-max-1)%MOD)%MOD;
                max = max+1;
            }
        }

        int min = indexes.get(median);
        for (int i = median; i >=0; i--) {
            Integer index = indexes.get(i);
            if (index < min) {
                sum = (sum + (min - index-1)%MOD)%MOD;
                min = min-1;
            }
        }


        return (int)(sum%MOD);
    }

    public static void main(String[] args) {
        System.out.println(new Seats().seats(".x.x.x..x"));
    }
}
