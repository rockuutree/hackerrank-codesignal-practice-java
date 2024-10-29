// Takes int n steps to reach the top

// Each time you can either climb 1 or 2 steps
// Find how many distinct ways you ca climb to the top

// DP (bottom up approach) memoization

// TC: O(n)
// SC: O(n)

class Solution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }

        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

}