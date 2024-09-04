// Time Complexity : O(log n)

// [3,4,5,1,2]
//  l.  m.   r

//  We would want to search after the middle, so left would be set to m + 1

class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int m = (l + r) / 2;
            // Binary search except, if the middle is greater, then we want to set our left pointer to the middle
            if(nums[m] < nums[r]) {
                // If middle is less than r, then it still follows the traditional binary search, so we set r to m;
                r = m;
            } else {
                l = m + 1;
            }
        }

        return nums[l];
    }
}