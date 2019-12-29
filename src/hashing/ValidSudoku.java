package hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSudoku {

    public int isValidSudoku(final List<String> A) {

        for (int i = 0; i < 9; i++) {
            Set<Character> rows = new HashSet<>();
            Set<Character> cols = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                char c = A.get(i).charAt(j);
                if (c!= '.' && rows.contains(c)) {
                    return 0;
                }
                rows.add(c);


                char v = A.get(j).charAt(i);
                if (v!= '.' && cols.contains(v)) {
                    return 0;
                }
                cols.add(v);
            }
        }

        for (int i = 0; i < 9; i = i+3) {

            for (int j = 0; j < 9; j = j+3) {
                Set<Character> box = new HashSet<>();
                for (int k = i; k < i+3; k++) {
                    for (int l = j; l < j+3; l++) {
                        System.out.println("i, j, k, l =" + i + ", " + j + ", " + k + ", "+ l);
                        char o = A.get(k).charAt(l);
                        if (o != '.' && box.contains(o)){
                            return 0;
                        }
                        box.add(o);
                    }
                }

            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(new ValidSudoku().isValidSudoku(Arrays.asList("..5.....6", "....14...", ".........", ".....92..", "5....2...", ".......3.", "...54....", "3.....42.", "...27.6..")));
    }

}
