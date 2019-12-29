package hashing;

public class WindowString {

    public String minWindow(String A, String B) {

        int right = 0, left = 0;
        int[] toFind = new int[128];
        int[] hasFound = new int[128];

        for (int i = 0; i < B.length(); i++) {
            toFind[B.charAt(i)]++;
        }

        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int x = 0, y = 0;
        while (right < A.length() && left < A.length()) {

            char c = A.charAt(right);
            hasFound[c]++;
            if (hasFound[c] <= toFind[c]) { // toFind is not 0
                count++;
            }

            if (count < B.length()) {
                right++;
                continue;
            }

            while (toFind[A.charAt(left)] < hasFound[A.charAt(left)]) {
                hasFound[A.charAt(left)]--;
                left++;
            }

            if (minLen > right - left + 1) {
                minLen = right - left + 1;
                x = left;
                y = right;
            }
            right++;

        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        return A.substring(x, y + 1);
    }


    public static void main(String[] args) {
        System.out.println(new WindowString().minWindow("ADOBECODEBANC", "ABC"));
    }
}