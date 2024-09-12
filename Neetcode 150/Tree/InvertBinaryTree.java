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
        // Returns null if the root node is null
        if(root == null) {
            return null;
        }

        // Need a temp to hold a root
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // Swaps the child nodes

        // Continues to do it recursively on both sides,
        invertTree(root.left);
        invertTree(root.right);

        // Returns the root
        return root;
    }
}