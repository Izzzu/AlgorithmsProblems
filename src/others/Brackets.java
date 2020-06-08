package others;

import java.util.*;

public class Brackets {
    public int solution(String S) {
        Stack<Character> stack = new Stack<>();

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (int i = 0; i < S.length(); i++) {
            if (map.containsValue(S.charAt(i))) {
                stack.add(S.charAt(i));
            } else if (map.containsKey(S.charAt(i))) {
                if (stack.isEmpty() || stack.pop() != map.get(S.charAt(i))) {
                    return 0;
                }
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
