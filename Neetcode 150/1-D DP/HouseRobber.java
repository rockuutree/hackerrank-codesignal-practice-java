// Context: You're a house robber

// - We cannot rob two adjacent houses in the same night

// Input:
// int[] nums -> representing the amount of money of each house
// index -> house
// nums[i] -> how much money the house has.


// TC: O(n)
// SC: O(n)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];

        dp[0] = nums[0]; //first house
        dp[1] = Math.max(nums[0], nums[1]); //second house

        for(int i = 2; i < n; i++) {
            // Comparing two cases: max money at prev house, or max money at cur house + i - 2 house
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i - 2]);
        }

        return dp[n-1];// return end value of dp array
    }


}