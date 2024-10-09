// - Goal: find the peak element and return its index


// TC = O(logn) binary search
// SC = O(1)
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {

            int middle = left + ((right - left) / 2);

            if(middle > 0 && nums[middle] < nums[middle - 1]) {
                right = middle - 1;
            }

            else if(middle < nums.length-1 && nums[middle] < nums[middle + 1]) {
                left = middle + 1;
            } else {
                return middle;
            }
            
        }
            return 0;
    }

}