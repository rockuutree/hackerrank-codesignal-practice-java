// Two pointer soluton where right will always move, and left will be at an index with a zero

class Solution {
    public void moveZeroes(int[] nums) {
        // Intitliaze pointers
        int left = 0;
        int right = 0;

        // While the right pointe is less than the length of the array
        while(right < nums.length) {
            // If the right pointer is at a non zero, then we want to swap the left and right pointer
            if(nums[right] != 0) {
                // Temp number to hold the swapped number
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                // Increment left pointer to move past the swap number
                left++;
            }
            // Increment right after an iteration
            right++;
        }
    }
}