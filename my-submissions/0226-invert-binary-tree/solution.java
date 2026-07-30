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
    public TreeNode invertTree(TreeNode root) {
        

        if(root == null) return null;
        Deque<TreeNode> stack = new ArrayDeque<>();

        stack.push(root);

        while(!stack.isEmpty()){

            TreeNode current = stack.pop();

            TreeNode temp = current.left;

            current.left = current.right;
            current.right = temp; 

            if(current.left != null){
                stack.push(current.left);
            }

            if(current.right != null){
                stack.push(current.right);
            }
        }
        return root;
    }
}
