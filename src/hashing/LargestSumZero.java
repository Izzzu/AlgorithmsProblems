package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestSumZero {
    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int maxLen  = 0;
        int maxInd = 0;
        int sum = 0;

        for (int i = 0; i < A.size(); i++) {
            Integer num = A.get(i);
            sum += num;
            if (num == 0 && maxLen ==0) {
                maxLen = 1;
                maxInd = i;
            }
            if (sum==0) {
                maxLen = i+1;
                maxInd = i;
            }

            if (map.containsKey(sum)) {
                if (i - map.get(sum)> maxLen) {
                    maxLen = i - map.get(sum);
                    maxInd = i;
                }
            } else {
                map.put(sum, i);
            }
        }

        if (maxInd == 0 && maxLen ==0) {
            return new ArrayList<>();
        }
        return new ArrayList<>(A.subList(maxInd + 1 - maxLen, maxInd + 1));

    }

    public static void main(String[] args) {

        System.out.println(new LargestSumZero().lszero(new ArrayList(Arrays.asList( 22, -7, 15, -21, -20, -8, 16, -20, 5, 2, -15, -24, 19, 25, 3, 23, 18, 0, 16, 26, 13, 4, -20, -13, -25, -2 ))));
    }
}
