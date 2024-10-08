// int[] numbers is already sorted in non decreasing

// x + y = target
// numbers[i] + numbers[j] = target

// Goal: return the indices of the two numbers

// [i, j] = length 2

// only one solution

// solution must use only constant extra space.

// TC: O(n)
// SC: O(1)

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] retVal = new int[2];

        int left = 0;
        int right = numbers.length - 1;


        while(left < right) {
            int sum = numbers[left] + numbers[right];

            if(sum == target) {
                retVal[0] = left + 1;
                retVal[1] = right + 1;

                return retVal;
            } else if(sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return retVal;
    }
}