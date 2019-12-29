package hashing;

/*
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 < index2. Please note that your returned answers (both index1 and index2 ) are not zero-based.
Put both these numbers in order in an array and return the array from your function ( Looking at the function signature will make things clearer ). Note that, if no pair exists, return empty list.

If multiple solutions exist, output the one where index2 is minimum. If there are multiple solutions with the minimum index2, choose the one with minimum index1 out of them.
 */

import java.util.*;

public class ToSum {
    public ArrayList<Integer> twoSum(final List<Integer> A, int B) {

        int index1 = -1;
        int index2 = -1;
        boolean solutionexists = false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            int subsum = B - A.get(i);
            if (map.containsKey(subsum)) {
                index2 = i;
                index1 = map.get(subsum);
                break;
            }
            if (!map.containsKey(A.get(i))) {
                map.put(A.get(i), i);
            }
        }

        if (index1 == -1 || index2 == -1) {
            return new ArrayList<>();
        } else {
            return new ArrayList<>(Arrays.asList(index1 + 1, index2 + 1));
        }
    }


    public static void main(String[] args) {
        System.out.println(new ToSum().twoSum(Arrays.asList(3, 2, 8, 1), 9
        ));
    }
}
