package graphs;

import java.util.ArrayList;

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
  }
 
public class LevelOrder {

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        levelOrder(result, A, 0);
        return result;
    }

    private void levelOrder(ArrayList<ArrayList<Integer>> result, TreeNode a, int level) {
        if (a == null) {
            return;
        }

        ArrayList<Integer> nextLevel;
        if (level>=result.size()) {
             nextLevel= new ArrayList<>();
             result.add(nextLevel);
        } else {
            nextLevel = result.get(level);
        }

        nextLevel.add(a.val);

        levelOrder(result, a.left, level+1);
        levelOrder(result, a.right, level+1);


    }

}
