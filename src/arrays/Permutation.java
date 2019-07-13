package arrays;

import java.util.HashMap;
import java.util.Map;

public class Permutation {
    static int DIVISOR = 1000003;
    static Map<Character, Integer> map = new HashMap<Character, Integer>();
    public static int findRank(String a) {
        if (a.length() == 1) {
            return 1;
        }
        for (int i = 0; i<a.length(); i++) {
            if (map.containsKey(a.charAt(i))) {
                int t = map.get(a.charAt(i));
                map.put(a.charAt(i), t+1);
            } else {
                map.put(a.charAt(i), 1);
            }
        }

        return (int)(find(a, map)% DIVISOR);
    }

    public static long find(String a, Map<Character, Integer> map) {
        if (a.isEmpty()) {
            return 1;
        }
        int sum = 1;
        for (char i : map.keySet()) {
            sum = sum* factorial(map.get(i));
        }
        int sortedPosition = getSortedPosition(a);
        long r = sortedPosition * factorial(a.length()-1);
        long posRank = r*(long)(Math.pow(sum, (DIVISOR-2)) % DIVISOR);
        int t =  map.get(a.charAt(0));
        if (t == 1) {
            map.remove(a.charAt(0));
        } else {
            map.put(a.charAt(0), t-1);
        }
        return (posRank + find(a.substring(1), map));
    }


    /**
     * Sorted position is the rank in ascending order of the first character.
     * input string should always be of length greater than 1.
     * @param a
     * @return
     */
    private static int getSortedPosition(String a) {
        int rank = 0;
        for (int i = 1; i < a.length(); i++) {
            if (a.charAt(i) < a.charAt(0)) {
                rank++;
            }
        }
        return rank;
    }

    /**
     * Method to return factorial of a number with mod of 1000003
     * @param n
     * @return
     */
    public static int factorial (int n) {
        int prod = 1;
        for (int i = 1; i <= n; i++) {
            prod *= i;
            prod %= DIVISOR;
        }
        return prod;
    }

    public static void main(String[] args) {
        System.out.println(findRank("baa"));
    }
}
