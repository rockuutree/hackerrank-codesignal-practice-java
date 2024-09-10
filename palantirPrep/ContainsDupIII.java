// You are given an integer array nums and two integers indexDiff and valueDiff.

// Goal: Return true when you find a pair of indices (i, j) that follow these rules:

// 1. i != j,
// 2. abs(i - j) <= indexDiff
// 3. abs(nums[i] - nums[j] <= valueDiff)

// false if otherwise

// Keep tracking of the indicies

// nums [1, 2, 3, 2] indexDiff = 2, valueDiff = 0

// i = 1
// j = 3

// 1 != 3

// abs(1 - 3) <= 2 true

// abs[2 - 2] = 0 <= 0 true



// return true;

// TC: O(n^2)
// SC: O(1)

// Window + two pointer solution
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int i = 0;
        int j = 1;

        // loops till j reaches the end
        while(j < nums.length) {
            // Intializes the current index dif and current value dif
            int currIndexDif = Math.abs(i - j);
            int currValueDif = Math.abs(nums[i] - nums[j]);

            // If our difs are <= then the target then return true
            if(currIndexDif <= indexDiff && currValueDif <= valueDiff) {
                return true;
            }

            // Edge case to ensure that our window will always be within the bounds of the indexDiff or if j reaches the end 
            else if(currIndexDif == indexDiff || j == nums.length-1) {
                // Increment our left pointer i
                i++;
                // reset right pointer to left
                j = i;

            }
            // Increment j so that it will be ahead.
            j++;
        }

        return false;
    }
}