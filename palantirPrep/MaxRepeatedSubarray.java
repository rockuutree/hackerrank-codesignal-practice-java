// Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.

// - Goal: Return a count/max length of a subarray that is apparent within both arrays

// DP based problem

// Time Complexity: O(n * m)
// Space Complexity: O(n * m) -> bc we keep track of the entire dp table
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        // Length of nums1
        int n = nums1.length;
        // Length of nums2
        int m = nums2.length;
        // Tracker for the max sublength (return value)
        int max = 0;

        // Createa a 2D dp grid 
        // Includes the + 1 for "0" for the blank stream;
        // Avoids index out of bounds and empty array cases
        int[][] dp = new int[n+1][m+1];

        // iterating through both arrays in a grid manner
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < m + 1; j++) {

                // If the current element matches
                if(nums1[i-1] == nums2[j-1]) {
                    // Increase the length of the common subarray
                    dp[i][j] = 1 + dp[i-1][j-1];
                }

                // Update the maximum length
                max = Math.max(max, dp[i][j]);
            }
        }
        return max
        return max;
    }
}