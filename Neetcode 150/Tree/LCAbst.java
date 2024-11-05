/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//  TC: O(log n)
//  SC: O(H)

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Empty tree
        if(root == null) {
            return root;
        }
        // If our root.val is greater than both p and q then we search for the left side
        if(root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q );
        }
        // If our root.val is less than both p and q, we search for a greater number 
        if(root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // if neither of the above cases are true then we return the root we're at
        return root;
    }
}