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

//  Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

// Structure needs to be the same
// Node needs to be the same
// Values need to be the samee

// TC: O(n * s)

// SC: O(n + s)

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Base case to see if both roots exist
        if(root == null) {
            return subRoot == null;
        }

        // Calls recursive function to see if the subtree from root is the same
        if(compareTree(root, subRoot)) {
            return true;
        }

        // Recursively checks each node until we return true or the end of each side
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

        
    }

    // Recursive function to check each subtree
    public boolean compareTree(TreeNode root, TreeNode subRoot) {
        // If we reach the end, then return true;
        if(root == null && subRoot == null) {
            return true;
        }
        
        // If one subtree ends earlier than the other, return false
        if((root == null && subRoot != null) || (subRoot == null && root != null)) {
            return false;
        }

        // If the values are different return false;

        if(root.val != subRoot.val) {
            return false;
        }
        // Check each side of the subtree
        return compareTree(root.left, subRoot.left) && compareTree(root.right, subRoot.right);
    }
}