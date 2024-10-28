// Given an integer array called nums

// int[] nums

// Goal: return an int array: answer
// - answer[i] == product of all nums except nums[i];

// - Can't use division operator and must run in O(n)

// TC: O(n)
// SC: O(n)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] retVal = new int[nums.length];
        // Key = index, product at ith index

        int product = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            
            suffix[i] = product;
            product *= nums[i];
        }

        product = 1;
        for(int i = 0; i < nums.length; i++) {
            
            prefix[i] = product;
            product *= nums[i];

            retVal[i] = prefix[i] * suffix[i];
        }


    return retVal;  
    }

    
}