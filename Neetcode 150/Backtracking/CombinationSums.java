// Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.


// int[] candidates <- all unique integers

// int target 

// Goal: Return a list of all "unique combinations" of candidates where the chose numbers sum to target

// - The same number can be chosen fro candidates an unlimited number of times.

class Solution {

    // Global variable
    List<List<Integer>> retVal;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        retVal = new ArrayList<>();
        // Recursively finds the combinatons
        dfs(candidates, target, 0, new ArrayList<>(), 0);
        return retVal;
    }

    private void dfs(int[] candidates, int target, int sum, List<Integer> temp, int i) {
        // If the sum matches with our target, then we want to add it to our return value list.
        if(sum == target) {
            retVal.add(new ArrayList<>(temp));
            return;
        }

        // Base case if sum is greater than target or out of bounds
        if(sum > target || i >= candidates.length) {
            return;
        }

        temp.add(candidates[i]);
        // Case where we use the same element
        dfs(candidates, target, sum + candidates[i], temp, i);
        // Case where we don't want to include the previous element, so we clean it up and just move onto the next index
        temp.remove(temp.get(temp.size() - 1));
        dfs(candidates, target, sum, temp, i + 1);
    }
}