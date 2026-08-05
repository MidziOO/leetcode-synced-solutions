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

    private int maxDiameter = 0; 

    public int diameterOfBinaryTree(TreeNode root) {
        longestPath(root);
        return maxDiameter;

    }
    public int longestPath(TreeNode node){
        
        if(node == null)return 0;

        int leftDepth = longestPath(node.left);
        int rightDepth = longestPath(node.right);

        maxDiameter = Math.max(maxDiameter, leftDepth+ rightDepth );

        return(Math.max(leftDepth, rightDepth ) + 1);   
    }
}
