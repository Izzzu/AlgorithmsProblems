package arrays;

import java.util.ArrayList;

public class PrettyPrint {
    public static ArrayList<ArrayList<Integer>> prettyPrint(int A) {
        int size = A*2-1;
        ArrayList<ArrayList<Integer>> rec = new ArrayList<ArrayList<Integer>>();
        for (int i = 0 ; i< size; i++) {
            ArrayList<Integer> l = new ArrayList<Integer>();
            for (int j = 0 ; j< size; j++) {
                l.add(0);
            }
            rec.add(l);
        }

        int t = 0;
        int b = size-1;
        int r = size-1;
        int l = 0;
        int d = 0;
        while(b>=t && l<=r) {
            if (d == 0 ) {
                for (int i = l; i<=r; i++) {
                    rec.get(t).set(i, (size+1)/2-l);
                }
                t++;
                d = 1;
            } else if (d == 1) {
                for (int i = t; i<=b; i++) {
                    rec.get(i).set(r, (size+1)/2-l);
                }
                r--;
                d = 2;
            } else if (d == 2) {
                for (int i = r; i>=l; i--) {
                    rec.get(b).set(i, (size+1)/2-l);
                }
                b--;
                d = 3;
            } else if (d == 3) {
                for (int i = b; i>=t; i--) {
                    rec.get(i).set(l, (size+1)/2-l);
                }
                l++;
                d = 0;
            }
        }
        return rec;
    }

    public static void main(String[] args) {
        System.out.println(prettyPrint(3));
    }
}
