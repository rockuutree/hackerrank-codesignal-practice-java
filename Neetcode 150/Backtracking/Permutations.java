// Given an array nums of distinct integers

// Return all possible permutations
// - Just all the ways a list of numbers can be written out
// - 123 321 231 312 examples

// TC: O(n! * n^2)
// SC: O(n! * n)
class Solution {

    // Global var
        List<List<Integer>> retVal;
        public List<List<Integer>> permute(int[] nums) {
            retVal = new ArrayList<>();
    
            // Run backtracking on this to find all combinations
            dfs(nums, new ArrayList<>());
    
            return retVal;
        }
    
    
        // takes in original array and temp arraylist
        private void dfs(int[] nums, List<Integer> temp) {
            // If the permutations list reaches same length as nums add it to our list of permutations
            if(temp.size() == nums.length) {
                retVal.add(new ArrayList<>(temp));
                return;
            }
    
            // Loop through nums array
            for(int i = 0; i < nums.length; i++) {
                // skip used numbers
                if(temp.contains(nums[i])) {
                    continue;
                }
                // Add them to the temp list
                temp.add(nums[i]);
                // Run dfs again
                dfs(nums, temp);
                // back track by removing the last added number
                temp.remove(temp.size()-1);
            }
            
            
        }
    }