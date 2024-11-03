
// TC: O(n)
// SC: O(n)

// Dp more memoization, exactly same as house robber but we create 2 array bc we start from different areas;

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        if(nums.length < 2) {
            return nums[0];
        }

        int[] startFrom1 = new int[nums.length+1];
        int[] startFrom2 = new int[nums.length+1];


        startFrom1[1] = nums[0];

        for(int i = 2; i <= nums.length; i++) {
            startFrom1[i] = Math.max(startFrom1[i-1], nums[i-1] + startFrom1[i - 2]);
            startFrom2[i] = Math.max(startFrom2[i-1], nums[i-1] + startFrom2[i - 2]);
        }

        return Math.max(startFrom1[nums.length-1], startFrom2[nums.length]);

    }
}