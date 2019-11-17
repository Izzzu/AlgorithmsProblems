package backtracking;

import java.util.ArrayList;

public class AllParentheses {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();

        StringBuilder temp = new StringBuilder();

        generate(result, temp, n, n);
        return result;
    }

    private void generate(ArrayList<String> result, StringBuilder temp, int open, int close) {

        if (open == 0 && close == 0) {
            result.add(temp.toString());
        }

        if (open>0) {
            temp.append("(");
            generate(result, temp, open-1, close);
            temp.deleteCharAt(temp.length()-1);
        }
        if (close>open) {
            temp.append(")");
            generate(result, temp, open, close-1);
            temp.deleteCharAt(temp.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new AllParentheses().generateParenthesis(3));
    }
}
