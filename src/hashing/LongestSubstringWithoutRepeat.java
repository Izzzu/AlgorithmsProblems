package hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeat {

    public int lengthOfLongestSubstring(String A) {

        Set<Character> temp = new HashSet<>();
        int longest = 0;
        int right = 0;
        int left = 0;
        while(right<A.length() && left<A.length()) {
            if (temp.contains(A.charAt(right))) {
                temp.remove(A.charAt(left));
                left++;
            } else {
                temp.add(A.charAt(right));
                right++;

                longest = Math.max(right - left, longest);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeat().lengthOfLongestSubstring("a"));
    }
}
