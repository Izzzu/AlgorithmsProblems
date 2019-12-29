package backtracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sudoku {
    static List<Character> nums = Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9');



    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        char[][] board = new char[a.size()][a.size()];
        for (int i = 0; i<a.size(); i++) {
            for (int j = 0; j<a.size(); j++) {
                board[i][j] = a.get(i).get(j);
            }
        }

        solve(board);


        for (int i = 0; i<a.size(); i++) {
            for (int j = 0; j<a.size(); j++) {
                a.get(i).set(j, board[i][j]);
            }
        }

    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }

                for (char k = '1'; k<='9'; k++) {
                    if (isValid(board, i, j, k)) {
                        board[i][j] = k;
                        if (solve(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }

                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) {
                return false;
            }

            if (board[row][i] != '.' && board[row][i] == c) {
                return false;
            }

            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.'
                    &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }


    private static ArrayList apply(String s) {
        return new ArrayList(Arrays.asList(s.toCharArray()));
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

        new Sudoku().solveSudoku(r);
        System.out.println(r);
    }
}
