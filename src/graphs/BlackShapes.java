package graphs;

import java.util.ArrayList;

public class BlackShapes {

    public int black(ArrayList<String> A) {

        if (A.isEmpty()) {
            return 0;
        }
        char[][] arr = new char[A.size()][A.get(0).length()];
        for (int i = 0; i < A.size(); i++) {
            arr[i] = A.get(i).toCharArray();
        }

        int shapes = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 'X') {
                    check(arr, i, j);
                    shapes++;
                }
            }
        }

        return shapes;
    }

    private void check(char[][] a, int i, int j) {
        a[i][j] = 'O';

        if (i<a.length-1 && a[i+1][j] == 'X') {
            check(a, i+1, j);
        }
        if (j<a[i].length-1 && a[i][j+1] == 'X') {
            check(a, i, j+1);
        }
        if (j>0 && a[i][j-1] == 'X') {
            check(a, i, j-1);
        }
        if (i>0 && a[i-1][j] == 'X') {
            check(a, i-1, j);
        }
    }
}
