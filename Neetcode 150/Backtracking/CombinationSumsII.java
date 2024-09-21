// TC: O(n + 2^n)
// SC: O(n + 2^n * k)

class Solution {
    // Global return value
     List<List<Integer>> retVal;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
       retVal = new ArrayList<>();
    //    Needs to be sorted so that we can compare prev
        Arrays.sort(candidates);
        backtrack(candidates, new ArrayList<>(), target, 0, 0);
        return retVal;
    }

    private void backtrack(int[] candidates, List<Integer> curCombo, int target, int sum, int pos) {
        if(sum == target) {
            retVal.add(new ArrayList<>(curCombo));
            return;
        } 
        // Can no longer reach the target so we only add numbers
        if(sum > target) {
            return;
        }
        // Input can't be negative
        int prev = -1;
        
        // Loops to find all possible combos from position
        for(int j = pos; j < candidates.length; j++) {
            // if we already use the previous then just continue so that we don't run into duplicates
            if(candidates[j] == prev) {
                continue;
            }

            // Add to current set
            curCombo.add(candidates[j]);
            // Backtrack with next index
            backtrack(candidates, curCombo, target, sum + candidates[j], j + 1);

            // Don't include the recent index
            curCombo.remove(curCombo.size() - 1);
            // Change prev so that we compare properly
            prev = candidates[j];
        }


    }
}