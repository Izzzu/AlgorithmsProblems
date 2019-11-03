package stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Parentheses {

    public int isValid(String A) {

        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');
        for(char c: A.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.isEmpty()){
                    return 0;
                }
                char sec = stack.pop();
                if (sec != map.get(c)) {
                    return 0;
                }
            } else if (map.containsValue(c)) {
                stack.push(c);
            } else {
                return 0;
            }
        }
        return stack.isEmpty() ? 1 : 0;

    }

}
