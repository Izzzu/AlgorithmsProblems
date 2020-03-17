package trees;

import java.util.ArrayList;

public class SumRoottoLeafNumbers {

    public static final long MOD = 1003;

    public int sumNumbers(TreeNode A) {
        long sum = 0;

        return (int)(sum(A, sum)%MOD);

    }

    public long sum(TreeNode A, long sum) {

        if (A == null) return sum;
        else sum = sum*10 + A.val;

        if (A.right == null && A.left == null) {
            return sum;
        }

        long left = sum(A.left, sum )%MOD;
        long right = sum(A.right, sum)%MOD;

        return (left + right)%MOD;


    }

    public long sum(TreeNode A, long sum, ArrayList<Integer> temp) {

        if (A == null) return sum;
        else temp.add(A.val);

        if (A.right == null && A.left == null) {
            for (int i = 0; i < temp.size(); i++) {
                sum += ((long)temp.get(i)*(long)Math.pow(10L, temp.size()-i-1))%MOD;

            }
            return sum;
        }

        long left = sum(A.left, sum , new ArrayList<>(temp))%MOD;
        long right = sum(A.right, sum , new ArrayList<>(temp))%MOD;

        return (left + right)%MOD;


    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        System.out.println(new SumRoottoLeafNumbers().sumNumbers(node));
    }

}
