// Given an integer array nums and an integer k, return the maximum length of a 
// subarray
//  that sums to k. If there is not one, return 0 instead.

//  int max = maximum length of a subarray

//  max = Math.max(max, ??)


// subarray[] = k

// Time Complexity: O(n)
// Space Complexity O(n)

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0;
        int max = 0;
        Map<Integer, Integer> prefixSums = new HashMap<>(); // key: cumulative sum until index i, value: i

        // Loop through the nums array
        for(int i = 0; i < nums.length; i++) {
            // Update cumulative sum
            sum += nums[i];
            // Our complement which is what we want to look for in prefixSums
            int complement = sum - k;
            
            // If our current sum == k, then we just want to increase our max
            if(sum == k) {
                max = i + 1;
                // If our hashmap contains an existing complement(cumulative sum till index i)
            } else if (prefixSums.containsKey(complement)) {
                // Set it to out biggest max so far.
                max = Math.max(max, i - prefixSums.get(complement));
            }

            // If our prefixSums doesn't contain the current cumulative sum, then we put it in our map at the current index.
            if(!prefixSums.containsKey(sum)) {
                prefixSums.put(sum, i);
            }

        }
        return max;
    }
}