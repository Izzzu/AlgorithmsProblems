package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LetterPhone {

    public ArrayList<String> letterCombinations(String A) {

        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        map.put(0, "0");
        map.put(1, "1");

        ArrayList<String> res = new ArrayList<String>();
        StringBuilder temp = new StringBuilder();
        bactrack(0, map, res, temp, A);
        return res;
    }

    private void bactrack(int nr, Map<Integer, String> map, ArrayList<String> res, StringBuilder temp, String A) {
        if (nr == A.length()) {
            res.add(temp.toString());
            return;
        }
        int k = (int) (A.charAt(nr) - '0');
        String seq = map.get(k);
        for (int i = 0; seq != null && i < seq.length(); i++) {
            temp.append(seq.charAt(i));
            bactrack(nr+1, map, res, temp, A);
            temp.deleteCharAt(temp.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterPhone().letterCombinations("23"));

    }
}
