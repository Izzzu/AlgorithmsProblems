package bitsmanipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MinXOR {
    public static int findMinXor(ArrayList<Integer> A) {

        Collections.sort(A);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i<A.size()-1; i++) {
            if ((A.get(i)^A.get(i+1)) < min) {
                min = A.get(i)^A.get(i+1);

            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(findMinXor(new ArrayList<Integer>(Arrays.asList(12, 4, 6, 2))));
    }
}
