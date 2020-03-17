package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestConsecutiveSequence {

    public int longestConsecutive(final List<Integer> A) {
        Map<Integer, Integer> map = new HashMap<>();
        Integer max = A.stream()
                .max(Integer::compareTo)
                .orElse(0);

        Integer min = A.stream()
                .min(Integer::compareTo)
                .orElse(0);

        int offset = 0;
        if (min<0) {
            offset = Math.abs(min);
        }
        for (int i = 0; i < A.size(); i++) {
            map.put(A.get(i)+offset, 1);
        }

        int start = 0;
        while(start<max+offset) {
            if (map.get(start)!=null) {
                break;
            } else {
                start++;
            }
        }

        int i = start+1;
        int len = 1;
        while(i<=max+offset+1) {
            if (map.get(i) == null) {
                len = Math.max(len, i-start);
                while(map.get(i) == null && i<=max+offset+1)
                    i++;
                start = i;
            } else {
                i++;
            }
        }


        return len;
}

    public static void main(String[] args) {
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(Arrays.asList(97, 86, 67, 19, 107, 9, 8, 49, 23, 46, -4, 22, 72, 4, 57, 111, 20, 52, 99, 2, 113, 81, 7, 5, 21, 0, 47, 54, 76, 117, -2, 102, 34, 12, 103, 69, 36, 51, 105, -3, 33, 91, 37, 11, 48, 106, 109, 45, 58, 77, 104, 60, 75, 90, 3, 62, 16, 119, 85, 63, 87, 43, 74, 13, 95, 94, 56, 28, 55, 66, 92, 79, 27, 42, 70 )));
    }
}
