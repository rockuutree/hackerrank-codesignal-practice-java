// // int[] nums

// Goal: 
// - Return true if any value appears at least twice (duplicate)
// - Return false, if no duplicates can be found, every number will be distinct

// // nums:  1, 2, 3, 3
// // 1, == nums[i] -> return true
// // 2 == nums[i] 

// -> return false 

// // n ^ 2

// Find the occuren of each number

// HashSet<Integer> 
// Key = number at i index

// hashset contains our key already
// return true

// n = length of our nums

// return false 

// TC: O(n)
// SC: O(l)

class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0 ; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                return true;
            }

            set.add(nums[i]);
        }
        
        return false;
    }
}