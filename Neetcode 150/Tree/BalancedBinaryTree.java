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

// TC: O(n)

// SC: O(h)

class Solution {

    // Global value
    private boolean retVal = true;

    public boolean isBalanced(TreeNode root) {
        // Empty tree so it's basically balanced
        if(root == null) {
            return true;
        }
        // Run dfs on the tree from the bottom up
        dfs(root);

        return retVal;
        
    }

    public int dfs(TreeNode root) {
        // Base case
        if(root == null) {
            return 0;
        }
        // Recursive on the left and right to find the height
        int left = dfs(root.left);
        int right = dfs(root.right);

        // If the tree is unbalanced (Height on one side is greater than the difference between both side > 1)
        if(Math.abs(left - right) > 1) {
            // Set retVal to false
            retVal = false;
        }
        // We want to use the max height from one particular side

        return 1 + Math.max(left, right);
    }
}