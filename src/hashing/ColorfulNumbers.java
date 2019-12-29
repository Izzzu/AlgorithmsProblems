package hashing;

import java.util.*;

public class ColorfulNumbers {
    public int colorful(int A) {
        String s = Integer.toString(A);
        Set<Integer> set = new HashSet<Integer>();
        int p = 1;
        for (int i = 0; i < s.length(); i++) {
            p = 1;
            for (int j = i; j < s.length(); j++) {
                p *= s.charAt(j) - '0';
                if (set.contains(p)) {
                    return 0;
                }
                else set.add(p);
            }
        }
        return 1;

    }
    public static void main(String[] args) {
        System.out.println(new ColorfulNumbers().colorful(234));
    }
}
