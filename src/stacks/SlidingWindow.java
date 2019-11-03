package stacks;

import java.util.*;

public class SlidingWindow {
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        // ArrayList<Integer> res = new  ArrayList<Integer>();
        // for (int i = 0; i<=A.size()-B; i++) {
        //     int max = Integer.MIN_VALUE;
        //     for (int j = i; j< i+B; j++) {
        //         max = Math.max(A.get(j), max);
        //     }
        //     res.add(max);
        // }
        // return res;

        Deque<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i<B && i<A.size(); i++) {
            while(!q.isEmpty() && A.get(q.peekLast()) <= A.get(i)) {
                q.removeLast();
            }
            q.addLast(i);
        }

        for (int i = B; i<A.size(); i++) {
            while(!q.isEmpty() && q.peek()<= i-B)
                q.removeFirst();

            while(!q.isEmpty() && A.get(q.peekLast()) <= A.get(i)) {
                q.removeLast();
            }
            q.addLast(i);
        }
        ArrayList<Integer> r = new ArrayList();
        while(!q.isEmpty()) {
            r.add(A.get(q.pollFirst()));
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(
                new SlidingWindow().slidingMaximum(Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1 ), 2));
    }

}
