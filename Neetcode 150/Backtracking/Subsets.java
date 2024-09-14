
// TC: O(n * 2^n)

// SC: O(n * 2^n)
class Solution {
    // Global value
    List<List<Integer>> retVal;
    public List<List<Integer>> subsets(int[] nums) {
        
        retVal = new ArrayList<>();

        // Run dfs/backtracking to find the subsets
        dfs(nums, new ArrayList<Integer>(), 0);

        // Return our global value
        return retVal;
    }

    // backtrack takes in the original array argument, a temp ArrayList and current index of the array we're at
    private void dfs(int[] nums, List<Integer> temp, int i) {
        // If it's out of bounds or we reach the end, then just add our set to our list of subsets
        if (i >= nums.length) {
            retVal.add(new ArrayList<>(temp));
            return;
        }

        // Case 1: Add the current number
        temp.add(nums[i]);
        // Move ahead
        dfs(nums, temp, i + 1); 

        // Case 2:Decision not to include the previous number
        temp.remove(temp.size()-1);
        // O(n)
        dfs(nums, temp, i + 1);


    }
}