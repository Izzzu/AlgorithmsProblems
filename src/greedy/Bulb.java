package greedy;

import java.util.ArrayList;

public class Bulb {

    public int bulbs(ArrayList<Integer> A) {

        int switches = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == 0) {
                if (switches%2 ==0) {
                    switches++;
                }
            } else {
                if (switches%2 == 1) {
                    switches++;
                }
            }
        }

        return switches;
    }

}
