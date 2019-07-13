package arrays;

import java.util.Arrays;
import java.util.List;

public class MaxConsecutiveGap {
    public static int maximumGap(final List<Integer> A) {
        if (A.size()<=1) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i<A.size(); i++) {
            min = Math.min(A.get(i), min);
            max = Math.max(A.get(i), max);
        }
        int n = A.size();
        float gap = (float)(max-min)/(float)(n-1);
        if (gap == 0.0) {
            return 0;
        }
        int[] maxB = new int[n];
        int[] minB = new int[n];
        Arrays.fill(minB, Integer.MAX_VALUE);
        Arrays.fill(maxB, Integer.MIN_VALUE);

        for (int i=0; i<A.size(); i++) {
            int ind = Math.round(((A.get(i)-min)/gap));
            maxB[ind] = Math.max(maxB[ind], A.get(i));
            minB[ind] = Math.min(minB[ind], A.get(i));
        }
        int maxDiff = 0;
        int val = minB[0];
        int prevMax = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++) {
            if (minB[i] == Integer.MAX_VALUE) {
                continue;
            }
            int diff = maxB[i] - minB[i];
            int diffBetweenBuckets = minB[i] - prevMax;
            prevMax = maxB[i];
            maxDiff = Math.max(Math.max(diff, diffBetweenBuckets), maxDiff);

        }
        if (minB[n-1] != Integer.MAX_VALUE) {
            maxDiff = Math.max(maxDiff, maxB[n-1] - minB[n-1]);
        }

        return maxDiff;

    }

    public static void main(String[] args) {
        int maximumGap = maximumGap(Arrays.asList(1, 1, 2));
        System.out.println(maximumGap);
    }
}
