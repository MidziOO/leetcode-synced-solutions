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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> results = new ArrayList<>();
        travers(root,results);
        return results;
        
    }

    private void travers(TreeNode node, List<Integer> results ){
        if(node == null )return;

        results.add(node.val);
        travers(node.left, results);
        travers(node.right, results);

    }
}
