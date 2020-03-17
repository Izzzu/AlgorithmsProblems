package heapAndMaps;

import java.util.HashMap;

public class WaysToMaxHeap {

    HashMap<Integer, Long> memo = new HashMap<Integer, Long>();
    long MOD = 1000000007l;
    long[][] nck = new long[101][101];
    int pow2[] = new int[11];

    public int solve(int A) {
        for (int i=1; i<101; i++) {
            nck[i][0] = 1l;
            nck[i][i] = 1l;
        }
        for (int i=2; i<101; i++) {
            for (int j=1; j<i; j++) {
                nck[i][j] = (nck[i-1][j-1] + nck[i-1][j])%MOD;
            }
        }
        pow2[0] = 1;
        for (int i=1; i<11; i++) {
            pow2[i] = 2*pow2[i-1];
        }

        memo.put(0, 1l);
        memo.put(1, 1l);
        memo.put(2, 1l);
        memo.put(3, 2l);
        memo.put(4, 3l);
        return ((int)findSol(A));
    }

    public int findHeight(int n) {
        int h = 0;
        while(n!=0) {
            n=n/2;
            h++;
        }
        return h;
    }

    public int findLeftTreeElements(int n) {
        int h = findHeight(n);
        return pow2[h-2]-1 + Math.min(n+1-pow2[h-1], pow2[h-2]);
        // number of elements in left tree up to height h-1 = pow2[h-2]-1;
        // elements remaining for last row = n-(pow2[h-1]-1).
    }

    public long findSol(int n) {
        if (memo.containsKey(n))
            return memo.get(n);
        ////////// solve //////////
        int leftTreeElements = findLeftTreeElements(n);
        long solution = (nck[n-1][leftTreeElements])%MOD;
        solution = (solution*findSol(leftTreeElements))%MOD;
        solution = (solution*findSol(n-1-leftTreeElements))%MOD;
        ///////////////////////////
        memo.put(n, solution);
        return solution;
    }
}
