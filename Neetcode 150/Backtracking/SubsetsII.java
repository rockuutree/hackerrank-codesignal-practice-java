// TC: O(n * n^2)

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // What we're adding all of our subsets to
        List<List<Integer>> retVal = new ArrayList<>();
        // Sorted order so that we can compare duplicates
        Arrays.sort(nums);
        // Backtrack
        backtrack(0, new ArrayList<>(), nums, retVal);

        return retVal;
    }
    // start = current index we're at
    // subset= what is our current subset look like now
    private void backtrack(int start, List<Integer> subset, int[] nums, List<List<Integer>> retVal) {
        // Add the current subset to our return value;
        retVal.add(new ArrayList<>(subset));
        // Skips duplicates that are next to eachother
        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]) {
                continue;
            }
            // All subsets that include nums[i]
            subset.add(nums[i]);
            // Pass in the next index into the subset
            backtrack(i + 1, subset, nums, retVal);
            // All subsets that doesn't include nums[i]
            subset.remove(subset.size() - 1);
        }
    }
}