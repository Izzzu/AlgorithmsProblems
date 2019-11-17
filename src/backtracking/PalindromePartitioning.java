package backtracking;

import java.util.ArrayList;

public class PalindromePartitioning {

    public ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<String>();
        getPalindromes(result, temp, 0, a);
        return result;
    }

    private void getPalindromes(ArrayList<ArrayList<String>> result, ArrayList<String> temp, int ind, String a) {
        if (temp.stream()
        .map(t-> t.length())
        .reduce((c, b) -> c+b).orElse(0) == a.length()) {
            result.add(new ArrayList<>(temp));
        }

        for (int i = ind+1; i<=a.length(); i++) {
            String sub = a.substring(ind, i);
            if (!isPalindrome(sub)) continue;
            temp.add(sub);
            getPalindromes(result, temp, i, a);
            temp.remove(temp.size()-1);
        }
    }

    private boolean isPalindrome(String sub) {
        int s = 0;
        int e = sub.length()-1;
        while(s<=e && sub.charAt(s) == sub.charAt(e) ) {
            s++;
            e--;
        }
        return (s > e);
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning().partition("aab"));
    }
}
