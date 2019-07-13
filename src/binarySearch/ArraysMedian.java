package binarySearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraysMedian {

    public static double findMedianSortedArraysOther(final List<Integer> a, final List<Integer> b) {
        if (a.size() + b.size() == 0) {
            return 0;
        }
        if (a.size() == 0 && b.size() != 0) {
            return simpleMedian(b);
        }
        if (b.size() == 0 && a.size() != 0) {
            return simpleMedian(a);
        }


        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.size(); i++) {
            min = Math.min(a.get(i), min);
            max = Math.max(a.get(i), max);
        }
        for (int i = 0; i < b.size(); i++) {
            min = Math.min(b.get(i), min);
            max = Math.max(b.get(i), max);
        }

        if ((a.size() + b.size()) % 2 == 0) {
            int medianIndex1 = (a.size() + b.size()) / 2;
            int medianIndex2 = (a.size() + b.size()) / 2 - 1;
            return (findMedian(min, max, a, b, medianIndex1) + findMedian(min, max, a, b, medianIndex2)) / 2;
        } else {
            int medianIndex = (a.size() + b.size()) / 2;
            return findMedian(min, max, a, b, medianIndex);
        }
    }

    public static double simpleMedian(final List<Integer> b) {
        if (b.size() % 2 == 0) {
            return (b.get(b.size() / 2) + b.get(b.size() / 2 - 1)) / 2;
        } else {
            return b.get(b.size() / 2);
        }
    }

    public static int getIndex(final List<Integer> a, int avg) {
        int index = 0;
        index = Collections.binarySearch(a, avg);
        if (index < 0) {
            index = Math.abs(index) - 1;
        } else {
//            while(index<a.size() && a.get(index) == avg) {
//                index++;
//            }
        }
        return index;
    }

    public static double findMedian(int minA, int maxA, final List<Integer> a, final List<Integer> b, int medianIndex) {

        int min = minA, max = maxA;
        while (min < max) {
            int avg = (min + max) / 2;
            int total = 0;
            int indexA = getIndex(a, avg);
            int indexB = getIndex(b, avg);
            total = indexA + indexB;
            if (total == medianIndex) {
                if (a.get(indexA) > b.get(indexB)) {
                    return a.get(indexA);
                } else return b.get(indexB);
            } else if (total < medianIndex) {
                min = avg + 1;
            } else {
                max = avg - 1;
            }
        }
        return min;
    }

    public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        if (a.size() + b.size() == 0) {
            return 0;
        }
        if (a.size() == 0 && b.size() != 0) {
            return simpleMedian(b);
        }
        if (b.size() == 0 && a.size() != 0) {
            return simpleMedian(a);
        }

        if (a.size() == 1 && b.size()==1) {
            return (a.get(0) + b.get(0))/2;
        }
        if (a.size()==1 && b.size()>1) {
            return getaDouble(a, b);
        }
        if (b.size()==1 && a.size()>1) {
            return getaDouble(b, a);
        }
        int m = a.size();
        int n = b.size();
        boolean odd = (m + n) % 2 != 0;
        int imin = 0;
        int imax = m;

        int i = 0;
        int j = 0;
        while (imin < imax) {
            i = (imin + imax) / 2;
            j = (m + n + 1) / 2 - i;
            if (b.get(j - 1) > a.get(i)) {
                imin = i + 1;
            } else if (a.get(i - 1) > b.get(j)) {
                imax = i - 1;
            } else {
                if (odd) {
                    return Math.max(a.get(i - 1), b.get(j - 1));
                } else {
                    return (Math.max(a.get(i - 1), b.get(j - 1)) + Math.min(a.get(i), b.get(j))) / 2;
                }
            }
        }
        return -1;
    }

    private static double getaDouble(List<Integer> a, List<Integer> b) {
        int med = Collections.binarySearch(b, a.get(0));
        if (med<0) {
            med = Math.abs(med)-1;
        }
        if (b.size()%2!=0) {

            if (med == b.size()/2) {
                return (a.get(0) + b.get(b.size()/2-1))/2;
            } else if (med == b.size()/2-1) {
                return (a.get(0) + b.get(b.size()/2))/2;
            } else {
                return (b.get((b.size()+1) / 2) + b.get((b.size()) / 2)) / 2;
            }
        } else {
            if (med == b.size()/2) {
                return a.get(0);
            } else {
                return b.get((b.size()+1)/2);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(Arrays.asList(-2), Arrays.asList(-43, -25, -18, -15, -10, 9, 39, 40)));
    }
}
