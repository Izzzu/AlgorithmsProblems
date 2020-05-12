package greedy;

import java.util.List;

public class CompleteCircuit {
    public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {

        int totalGas = 0;
        int totalLength = 0;
        int remaining = 0;
        int startInd = 0;

        for (int i = 0; i < A.size(); i++) {
            int gas = A.get(i);
            int len = B.get(i);
            remaining += (gas-len);
            if (remaining<0) {
                remaining = 0;
                startInd = i+1;
            }
            totalGas += gas;
            totalLength += len;
        }

        if (totalGas<totalLength) {
            return -1;
        }
        return startInd;
    }
}
