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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
         List<Integer> currentPath = new ArrayList<>();  
         List<List<Integer>> res = new ArrayList<>();
        dfs(root,targetSum,currentPath, res );
        return res;
    }
    private void dfs(TreeNode node, int targetSum, List<Integer> currentPath, List<List<Integer>> res ){
        if(node == null)return;

        currentPath.add(node.val);

        if(node.left == null && node.right == null && node.val == targetSum){
            res.add(new ArrayList<>(currentPath));
        }

        else{
            dfs(node.left, targetSum - node.val, currentPath, res);
            dfs(node.right, targetSum - node.val, currentPath, res);

            }
        currentPath.remove(currentPath.size() -1 );
    }
} 

