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
//  SC: O(n)
class Solution {
    //     public int maxDepth(TreeNode root) {
    //         if(root == null) {
    //             return 0;
    //         }
    
    //         int leftSide = maxDepth(root.left);
    //         int rightSide = maxDepth(root.right);
    
    //         return Math.max(leftSide, rightSide) + 1;
    //     }
    // }
    
    // Iterative versions
    
    // DFS
    
    public int maxDepth(TreeNode root) {
        // If our tree is empty
        if(root == null) {
            return 0;
        }   
        // Tranverse through the right side before the left side
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        // Hold the value associated with the node
    
        // Push in the node with its value
        stack.push(root);
        value.push(1);
        // Counter for the max level
        int max = 0;
    
        // Until we visited all the nodes
        while(!stack.isEmpty()) {
            // Look at whatever is at the top of the stack
            TreeNode node = stack.pop(); // 9
            int temp = value.pop(); // 2
    
            // Compares max with current and associated value
            max = Math.max(temp, max); // 3
            // If they have children, we push them in the stack and push their value in the value statck
            if(node.left != null) {
                stack.push(node.left); // 
                value.push(temp + 1); // 3
            
            if(node.right != null) {
                stack.push(node.right); // 9 
                value.push(temp+1); // 3
            }
        }
        // Return max in the end
        return max;
    }
    }
    