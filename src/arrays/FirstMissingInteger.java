package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstMissingInteger {
    public static int firstMissingPositive(ArrayList<Integer> A) {
        if (A.size() == 1) {
            if (A.get(0) <= 0) {
                return 1;
            } else {
                return A.get(0) + 1;
            }
        }
        List<Integer> B = segregate(A);

        for (int i = 0; i < B.size(); i++) {
            if (B.get(i) > 0 && B.get(i) <= B.size()) {
                int x = B.get(i);
                if (x-1 < B.size() && B.get(x-1) > 0) {
                    B.set(x-1, -B.get(Math.abs(x)-1));
                }
            }
//            } else if (B.get(i) > 0 && B.get(i) >= B.size()) {
//                B.set(i, -1);
//            }
        }

        for (int i =0; i<B.size(); i++) {
            if (B.get(i)>0) {
                return i+1;
            }
        }
        return B.size()+1;

    }

    public static List<Integer> segregate(List<Integer> A) {
        int j = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) < 0) {
                int temp = A.get(i);
                A.set(i, A.get(j));
                A.set(j, temp);
            }
        }
        return A.subList(j, A.size());
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new ArrayList<>(Arrays
                .asList(1, 2, 3, 4, 5, 6))));
    }
}
