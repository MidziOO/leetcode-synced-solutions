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
    public int count = 0;

    public int averageOfSubtree(TreeNode root) {
        countAverage(root );
        return count;

    }
    private int [] countAverage(TreeNode node){
        
        if (node == null) return new int[]{0,0};

        int [] leftAvg = countAverage(node.left);
        int [] rightAvg = countAverage(node.right);

        int currentSum = leftAvg[0] + rightAvg[0] + node.val; 
        int currentCount = leftAvg[1] + rightAvg[1] + 1;

        if(currentSum/currentCount == node.val){
            count ++;
        }
        return new int[]{currentSum, currentCount}; 
    }
}   
