package elementsOfProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class KthSmallest {
    public int kthsmallest(final List<Integer> A, int B) {
        if (A.isEmpty()) {
            return 0;
        }

        List<Integer> res = new ArrayList<Integer>();

        int low = Integer.MIN_VALUE;
        int high = Integer.MAX_VALUE;


        int r = A.get(0);

        int i = 0;
        int ind = 0;
        int count = 0;
        while(i<A.size()) {
            int duplicates = 0;
            count = 0;
            Integer val = A.get(i);
            if (val <low || val >high) {
                i++;
            } else {
                for (int j = 0; j<A.size(); j++) {
                    if (val >A.get(j)) {
                        count++;
                    } else if (val == A.get(j)) {
                        duplicates++;
                    }
                }
                if (count+1<=B && count+duplicates>=B) {
                    return val;
                } else if (count<B) {
                    low = val;
                } else {
                    high = val;
                }
                i++;
            }
        }

        return -1;


    }

    public static void main(String[] args) {
        System.out.println(new KthSmallest().kthsmallest(Arrays.asList(60, 94, 63, 3, 86, 40, 93, 36,
                56, 48, 17, 10, 23, 43, 77, 1, 1, 93, 79, 4, 10, 47, 1, 99, 91, 53, 99,
                18, 52, 61, 84, 10, 13, 52, 3, 9, 78, 16, 7, 62), 22));
    }

//    public int kthSmallest(List<Integer> A, int l, int r, int k) {
//        if (k>0 && k<=r-l+1) {
//            int n = r-l+1;
//
//            int i =0;
//
//            int []median = new int[(n+4)/5];
//
//            for (i = 0; i<n/5; i++) {
//                median[i] = findMedian(A, l+i*5, 5);
//            }
//
//            if (i*5<n) {
//                median[i] = findMedian(A, l+i*5, n%5);
//            }
//
//            int medOfMed = (i == 1) ? median[i-1] : kthSmallest(Arrays
//                    .stream(median).boxed().collect(Collectors.toList()), 0, i-1, i/2);
//
//            int po = partition(A, l, r, medOfMed);
//
//            if (po == k) {
//                return A.get(po);
//            }
//            if (po > k) {
//                return kthSmallest(A, l, po-1, k);
//            }
//
//            return kthSmallest(A, po+1, r, k-po+l-1);
//
//
//
//        }
//
//        return Integer.MAX_VALUE;
//    }
//
//    int partition(List<Integer> A, int l , int r, int x) {
//
//        int i;
//        for (i = l; i < r; i++)
//            if (A.get(i)== x)
//                break;
//        swap(arr, i, r);
//
//        // Standard partition algorithm
//        i = l;
//        for (int j = l; j <= r - 1; j++)
//        {
//            if (arr[j] <= x)
//            {
//                swap(arr, i, j);
//                i++;
//            }
//        }
//        swap(arr, i, r);
//        return i;
//    }
//
//
//    public int findMedian(final List<Integer> A, int l, int n) {
//
//        List<Integer> list = A.subList(l, l+n);
//        Collections.sort(list);
//        return list.get(n/2);
//
//
//
//    }



}
