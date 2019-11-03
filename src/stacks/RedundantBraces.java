package stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class RedundantBraces {

    public int braces(String A) {
        Stack<Character> open = new Stack<>();
        List<Character> operators = Arrays.asList('+', '-', '*', '/');
        for (int i = 0; i<A.length(); i++) {
            if (A.charAt(i) == '(') {
                open.push('(');
            } else  if(operators.contains(A.charAt(i))) {
                if (!open.isEmpty()) {
                    open.pop();
                }
            }
        }

        if (open.isEmpty()) {
            return 0;
        }
        return 1;
    }

}
