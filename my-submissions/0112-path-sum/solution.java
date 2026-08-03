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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        Deque<TreeNode> nodeStack= new ArrayDeque<>();
        nodeStack.push(root);

        Deque<Integer> sumStack = new ArrayDeque<>();
        sumStack.push(root.val); 

        while(!nodeStack.isEmpty()){

            int currentSum = sumStack.pop();
            TreeNode node = nodeStack.pop();

            if(node.left == null && node.right == null && currentSum == targetSum){
                return true;
            }

            if(node.left != null){
                nodeStack.push(node.left);
                sumStack.push(currentSum + node.left.val);
            }

            if(node.right != null){
                nodeStack.push(node.right);
                sumStack.push(currentSum + node.right.val);
            }
        }
        return false; 

    }
}
