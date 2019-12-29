package backtracking;

import java.util.ArrayList;

public class NQueens {
    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> temp = new ArrayList<String>();
        ArrayList<String> available = init(a);

        generateSolutions(result, temp, available);
        return result;
    }

    private ArrayList<String> init(int a) {
        StringBuilder row = new StringBuilder();
        ArrayList<String> board = new ArrayList<String>();
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < i; j++) {
                row.append('.');
            }
            row.append('Q');
            for (int j = i + 1; j < a; j++) {
                row.append('.');
            }
            board.add(row.toString());
            row.delete(0, row.length());
        }
        return new ArrayList<>(board);
    }

    private void generateSolutions(ArrayList<ArrayList<String>> result, ArrayList<String> temp, ArrayList<String> available) {
        if (available.isEmpty()) {
            result.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < available.size(); i++) {
            String row = available.remove(i);
            if (isValid(row, temp)) {
                temp.add(row);
                generateSolutions(result, temp, available);
            }
            available.add(i, row);
            temp.remove(row);
        }

    }

    private boolean isValid(String row, ArrayList<String> temp) {
        int posQ = row.indexOf('Q');
        for (int i = 1; i <= temp.size(); i++) {
            String currentRow = temp.get(temp.size() - i);
            int posQInCurrRow = currentRow.indexOf('Q');
            if (posQInCurrRow + i == posQ || posQInCurrRow - i == posQ) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new NQueens().solveNQueens(4));
    }
}
