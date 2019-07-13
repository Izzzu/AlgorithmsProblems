package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MatrixMedian {
    public static  int findMedian(ArrayList<ArrayList<Integer>> A) {
        if (A.size()==1) {
            return A.get(0).get(A.get(0).size()/2);
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i =0; i<A.size(); i++) {
            if (A.get(i).get(0) < min) {
                min = A.get(i).get(0);
            }
            if (A.get(i).get(A.get(i).size()-1) > max) {
                max = A.get(i).get(A.get(i).size()-1);
            }
        }
        int medianIndex = (A.size()*A.get(0).size())/2+1;

        while(min<max) {
            int count = 0;
            int mid = (max+min)/2;
            int getAll = 0;
            int get = 0;
            for (int i = 0; i< A.size(); i++) {
                get = Collections.binarySearch(A.get(i), mid);
                if (get<0) {
                    get = Math.abs(get)-1;
                } else {
                    while(get<A.get(i).size() && A.get(i).get(get) == mid) {
                        get = get+1;
                    }
                }
                getAll = getAll + get;
            }
            if(getAll<medianIndex) {
                min = mid+1;
            } else {
                max = mid;
            }


        }
        return min;

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
        arrayList.add(new ArrayList<Integer>(Arrays.asList(1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3)));
        System.out.println(findMedian(arrayList));
    }
}
