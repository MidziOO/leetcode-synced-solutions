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
    public boolean isValidBST(TreeNode root) {
        
        return checkLimits(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean checkLimits(TreeNode node, Long min, Long max){
           
           if(node == null) return true;


            if(node.val<= min || node.val >= max) return false;


            boolean checkLeft = checkLimits(node.left, min , (long) node.val);
            boolean checkRight = checkLimits(node.right, (long) node.val, max);

            return checkRight && checkLeft;

    }
}
