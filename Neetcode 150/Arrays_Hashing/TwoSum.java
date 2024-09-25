// Given an array of integers nums
// int[] nums

// int target

// Goal: Return an array, which consists of the two indicies of the two numbers that add up to target
// - Storing the indicies not the number
// - Numbers should add up to target

// You cannot use the same element twice.
// Each input has exactly one solution

// Target = 9, 
// nums = [1, 2,3, 4, 5]

// 1 + 2 = 3
//  1 + 3 = 4
// 1 + x = 9
// 9 - 1 = x = 8

// HashMap
// Integer, Integer
// Key = Complement, 
// value = The index that we used to find complement, 
// 5 and 3 

// TC: O(n)
// SC: O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] retVal = new int[2];

        // Loop through nums array
        for(int i = 0 ; i < nums.length; i++) {
            // Find the other half of the number based off the current number and target
            int complement = target - nums[i];

            // If we already have the complement in the map
            if(map.containsKey(complement)) {
                // Add them to our return value
                retVal[0] = map.get(complement);
                retVal[1] = i;
            } else {
                // Otherwise we put in the current number and its index
                map.put(nums[i], i);
            }
        }

        return retVal;
    }
}