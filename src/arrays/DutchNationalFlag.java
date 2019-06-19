package arrays;

import java.util.Collections;
import java.util.List;

public class DutchNationalFlag {
    public enum Color {RED, WHITE, BLUE}
    public static void dutchFlagPartition(int pivotIndex, List<Color> A) {
        Color pivot = A.get(pivotIndex);
        int smaller = 0, larger = A.size();
        int index = 0;
        while(index<larger) {
            if(A.get(index).ordinal() < pivot.ordinal()) {
                Collections.swap(A, index, smaller);
                smaller++;
                index++;
            } else if (A.get(index).ordinal() > pivot.ordinal()) {
                larger--;
                Collections.swap(A, index, larger);
            } else {
                index++;
            }
        }
    }
}
