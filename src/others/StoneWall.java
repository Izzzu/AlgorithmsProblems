package others;

import java.util.Stack;

public class StoneWall {

    public int solution(int[] H) {
        int curr = 0;
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while(i<H.length) {
            if (curr != H[i]) {
                if (stack.isEmpty()) {
                    stack.add(H[i]);
                    count++;
                    curr = H[i];
                    i++;
                } else if (curr < H[i]) {
                    stack.add((H[i]-curr));
                    count++;
                    curr += (H[i]-curr);
                    i++;
                } else {
                    while(!stack.isEmpty() && (curr = curr - stack.pop()) > H[i]);
                }
            } else {
                i++;
            }
        }

        return count;
    }
}
