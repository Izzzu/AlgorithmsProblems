package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class SmallestMultipleWith0And1 {

    public String multiple(int n) {
        if (n==1) {
            return String.valueOf(n);
        }

        Queue<Long> queue = new LinkedList<>();

        queue.add(1L);
        long ans = Integer.MAX_VALUE;

        String a = "";
        String b = "";

        while(!queue.isEmpty() && b.length()<10) {
            long k = queue.poll();
            a = k + "0";
            b = k + "1";

            long x = Long.parseLong(a);
            long y = Long.parseLong(b);
            if (x%n==0) {
                if (x>=n) {
                    ans = Math.min(ans, x);
                }
            }
            if (y%n==0) {
                if (y>=n) {
                    ans = Math.min(ans, y);
                }
            }

            queue.add(x);
            queue.add(y);
        }

        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        System.out.println(new SmallestMultipleWith0And1().multiple(10));
    }

}
