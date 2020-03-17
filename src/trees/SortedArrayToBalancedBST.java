package trees;

public class SortedArrayToBalancedBST {
    public TreeNode sortedArrayToBST(final int[] A) {


        return find(A, 0, A.length-1);
    }

    private TreeNode find(int[] A, int start, int end) {
        if (start<=end) {
            int mid = (end+start)/2;
            TreeNode root = new TreeNode(A[mid]);
            if (start<mid) root.left = find(A, start, mid-1);
            if (end>mid)  root.right = find(A, mid+1, end);
            return root;


        }
        return null;
    }


    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(new SortedArrayToBalancedBST().sortedArrayToBST(arr).val);
    }


}
