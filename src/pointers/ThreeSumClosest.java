package pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSumClosest {
    public static int threeSumClosest(ArrayList<Integer> A, int B) {
        Collections.sort(A);

        long diff = 2147483647L*3+1;
        long res = 0;
        for (int i = 0; i<A.size()-1; i++) {
            int l = i+1;
            int r = A.size()-1;
            int k = A.get(i);
            while(l<r) {
                long sum = (k + A.get(l) + A.get(r));
                if (sum == B) {
                    return B;
                } else {
                    if (diff> Math.abs(B-sum)) {
                        diff = Math.abs(B-sum);
                        res = sum;


                    }
                    if (sum>B) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }


        }
        return (int)res;
    }
    // -9 -8 -8 -8 -7 1 2 2 2 3


    public static void main(String[] args) {
        System.out.println(threeSumClosest(new ArrayList<>(Arrays.asList(2, 1, -9, -7, -8, 2, -8, 2, 3, -8
)), -1));
    }
}
