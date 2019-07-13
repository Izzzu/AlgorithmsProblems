package arrays;

import java.util.HashMap;
import java.util.Map;

public class Excel {
    public static String convertToTitle(int A) {
        StringBuilder s = new StringBuilder();
        Map<Integer, Character> map = new HashMap<Integer, Character>();

        int m = 1;
        for (char k= 'A';k<='Z'; k++) {
            map.put(m, k);
            m++;
        }
        map.put(20, 'U');
        map.put(21, 'T');
        map.put(0, 'Z');
        int n = A;
        int i = 0;
        while(n>0) {
            int ind = n%26;
            char c = map.get(ind);
            s.append(c);
            i++;
            n = (n-ind)/26;
        }
        return s.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(943566));
    }
}
