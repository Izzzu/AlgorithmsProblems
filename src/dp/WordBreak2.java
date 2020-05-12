package dp;

import java.util.ArrayList;
import java.util.Arrays;

public class WordBreak2 {
    public ArrayList<String> wordBreak(String A, ArrayList<String> B) {

        ArrayList<String> result = new ArrayList<>();
        wordBreak(0, A.length(), B, A, result, "");
        return result;
    }

    private void wordBreak(int start, int end, ArrayList<String> b, String A, ArrayList<String> result, String res) {

        if (start == end) {
            result.add(res);
        }
        for (int i = start + 1; i <= end; i++) {
            String substring = A.substring(start, i);
            if (b.contains(substring)) {
                if (start == 0) {
                    wordBreak(i, A.length(), b, A, result, substring);
                } else {
                    wordBreak(i, A.length(), b, A, result, res + " " + substring);
                }
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(new WordBreak2().wordBreak("catsanddog", new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));
    }

}
