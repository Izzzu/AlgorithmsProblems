package bitsmanipulation;

import java.util.ArrayList;
import java.util.Arrays;

public class CountBits {

    public static int cntBits(ArrayList<Integer> A) {
        long total = 0;
        for (int i = 0; i<32; i++) {
            long sum = 0;
            for (int j = 0; j<A.size(); j++) {
                if ((A.get(j) & (1L<<i)) != 0) {
                    sum++;
                }
            }
            total += ((sum%1000000007L)*((A.size()-sum)%1000000007L))%1000000007L;
        }
        return (int)(((total%1000000007L)*2L)%1000000007L);
    }

    public static void main(String[] args) {
        System.out.println(cntBits(new ArrayList<>(Arrays.asList(Integer.MAX_VALUE))));
    }
}
