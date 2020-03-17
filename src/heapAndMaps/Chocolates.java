package heapAndMaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Chocolates {
    public int nchoc(int K, ArrayList<Integer> B) {


        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(B);
        long sum = 0;
        while (K>0) {
            int bag = pq.poll();
            sum = (sum+bag)%1000000007L;
            pq.add(bag/2);
            K--;
        }

        return (int)(sum%1000000007L);

    }


    public static void main(String[] args) {
        System.out.println(new Chocolates().nchoc(10, new ArrayList<>(Arrays.asList( 2147483647, 2000000014, 2147483647))));
    }


}
