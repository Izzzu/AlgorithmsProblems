package stacks;

import java.util.Stack;

public class SimplifyPath {

    public static String simplifyPath(String A) {
        Stack<String> dirs = new Stack<String>();
        for (String s : A.split("/")) {
            if (s.equals("..")) {
                if (!dirs.isEmpty()) {
                    dirs.pop();
                }
            } else if (s.equals(".") || s.isEmpty()) {
            } else {
                dirs.push(s);
            }
        }
        Stack<String> reverted = new Stack<String>();
        while(!dirs.isEmpty()) {
            reverted.push(dirs.pop());
        }

        StringBuilder res = new StringBuilder();

        while(!reverted.isEmpty()) {
            res.append("/");
            res.append(reverted.pop());
        }
        String d = res.toString();
        if (d.length() == 0) {
            return "/";
        }

        return d;
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/./b/../../c/"));
    }
}
