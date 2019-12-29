package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetsSimplest {

    public List<List<Integer>> subsets(List<Integer> A) {
        if (A == null )
            return null;

        // sort to create subsets in ascending order (lexicographic)
        Collections.sort(A);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempSolution = new ArrayList<>();

        generateSubsets(A, tempSolution, result, 0);
        result.add(0, new ArrayList<>());
        return result;

    }

    private void generateSubsets(List<Integer> A, List<Integer> tempSolution, List<List<Integer>> result, int index) {

        // process solution, in this case we don't need to check - we know that every subset is a final solution
        // we just skip first execution as it's covered later
        if (index != 0) {
            result.add(new ArrayList<>(tempSolution));
        }

        for (int i = index; i<A.size(); i++) {
            // make a move
            tempSolution.add(A.get(i));

            // process the input based on current tempSolution
            // increment index because we already used A.get(i)
            generateSubsets(A, tempSolution, result, i+1);

            // revert the move
            tempSolution.remove(tempSolution.size()-1);
        }

    }

}
