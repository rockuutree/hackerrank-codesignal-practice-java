// TC: O(n)
// SC: O(k)

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int r = 0;
        int l = 0;
        long sum = 0;
        long max = 0;
        HashSet<Integer> window = new HashSet<>();
        while(r < nums.length) {
            // If our window is greater than k or contains a duplicate
            // Remove the left index until these conditions are false
            if(window.size() >= k || window.contains(nums[r])) {
                int left = nums[l];
                window.remove(left);
                sum -= left;
                l++;
                // Adds numbers to our window
            } else {
                window.add(nums[r]);
                sum += nums[r];
                r++;
            }
            // We only set the max once we have a valid sub array
            if(window.size() == k) {
                max = Math.max(max,sum);
            }
        }
        return max;
    }
}