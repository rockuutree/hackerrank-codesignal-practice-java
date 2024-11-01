
// int[] array cost 
// - cost[i] = cost of ith step on a staircase
// - Once you pay the cost you can climb one or two steps

// Start froms tep with index 0 or step with index 1

// return min cost to reach the top of the floor

// TC: O(n)
// SC: O(n)

// Memoization + Dp = mind confusing styuff
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // Loop through cost
        for(int i = 2; i < cost.length; i++) {
            // Add cost at i based off the minimum of the previous 2 indicies
            // We can climb one or two steps
            cost[i] += Math.min(cost[i-1],cost[i-2]);
        }

        // We either return the min at the top of the stairs or the stair just before the top
        return Math.min(cost[n-1], cost[n-2]);
    }
}