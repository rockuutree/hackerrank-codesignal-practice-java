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

//  TC: O(n)
//  SC: O(h)
class Solution {

    // Global variable to hold our diameter
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // Calls a helper function
        dfs(root);
        // Using a global variable to return the diameter rather than the height
        return diameter;
    }


    public int dfs(TreeNode root) {
        // Base Case
        if(root == null) {
            return 0;
        }
        // Recursive calls on the children
        int left = dfs(root.left);  
        int right = dfs(root.right);

        // Diameter of a node will be based on the left side + right side edges
        diameter = Math.max(diameter, left + right);

        // Height vs diameter, max of the right or left and add one for the edge to find the parent;
        return 1 + Math.max(left, right);
    }
}