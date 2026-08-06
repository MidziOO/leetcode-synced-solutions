/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        PathSum(root);
        return maxPath;
    }

    private int PathSum(TreeNode node){

       if(node == null) return 0;

       int leftSum = Math.max(0, PathSum(node.left));
       int rightSum = Math.max(0, PathSum(node.right));

        int currentSum = leftSum + rightSum + node.val; 

        maxPath = Math.max(maxPath, currentSum);

       return(Math.max(node.val + leftSum, node.val +rightSum)); 
    }
}
