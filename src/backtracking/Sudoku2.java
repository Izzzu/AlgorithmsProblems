package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sudoku2 {
    static List<Character> nums = Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9');

    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        ArrayList<ArrayList<Character>> temp = new ArrayList<ArrayList<Character>>();
        int free = a.stream()
                .map(r -> r.stream().filter(c -> c == '.').count())
                .reduce((d, b) -> d + b).map(t -> t.intValue()).orElse(0);

        solve(temp, a, free, 0);

    }

    private boolean solve(ArrayList<ArrayList<Character>> temp, ArrayList<ArrayList<Character>> a, int free, int index) {
        if (free == 0) {
            return true;
        }
        for (int i = index; i < a.size(); i++) {
            List<Character> row = a.get(i);
            List<Character> available = nums.stream().filter(n -> !row.contains(n)).collect(Collectors.toList());
            int pos = row.indexOf('.');
            for (int j = 0; j < available.size(); j++) {
                Character candidate = available.get(j);
                if (isValid(a, candidate, pos)) {
                    row.set(pos, candidate);
                    if (solve(temp, a, free-1, index)) {
                        return true;
                    }
                    row.set(pos, '.');
                }
            }
            return false;


        }
        return false;

    }

    private boolean isValid(ArrayList<ArrayList<Character>> a, Character candidate, int pos) {
        return a.stream()
                .map(row -> row.get(pos))
                .noneMatch(c -> c == candidate);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Character>> r = new ArrayList<ArrayList<Character>>();
        for (String s : Arrays.asList("53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79")) {
            ArrayList<Character> row = new ArrayList<Character>();
            for (int i = 0; i < s.length(); i++) {
                row.add(s.charAt(i));
            }
            r.add(row);

        }
        System.out.println(r);

        new Sudoku2().solveSudoku(r);
        System.out.println(r);
    }

}
