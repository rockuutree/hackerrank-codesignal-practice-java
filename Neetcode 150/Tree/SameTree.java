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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base case, if the nodes are both null, then we reach the end
        if(p == null && q == null) {
            return true;
        }
        // If one node is null but the other isn't then it's not the same
        if((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        // If there are both nodes available, but one value is different, return false;
        if(p.val != q.val) {
            return false;
        }

        // Both sides of the tree need to return true to return true overall
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);


    }
}