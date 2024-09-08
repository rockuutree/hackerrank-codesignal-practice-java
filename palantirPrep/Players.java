// // You are given an integer array matches where matches[i] = [winneri, loseri] indicates that the player winneri defeated player loseri in a match.

// // matches[i]  = [winneri, loseri]


// // Return a list answer of size 2 where:
// // answer[0] = list of all players that haven't lost
// HashMap -> No losts
// // answer[1] list of all plays that have lost only on match
// HashMap -> Lost only one

// // You should only consider the players that have played at least one match.

// List<List<Integer>> answer = new ArrayList<>();

// answer.get(0) -> No losts
// answer.get(1) -> only one lost

// Increasing order

// Time Complexity: O(n logn)
// Space Complexity: O(n)
class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        // Create a hashset to container the winners with no losses
        HashSet<Integer> winners = new HashSet<>();
        // HashMap to contain the players with losses
        HashMap<Integer, Integer> oneLost = new HashMap<>();

        for(int[] match : matches) {
            // First index are wins
            int win = match[0];
            // Second index are losses
            int lost = match[1];
            
            // If our losing hashmap doesn't contain win then we add the player to the set
            if (!oneLost.containsKey(win)) {
                winners.add(win);
            }
            // Increment our losing player's lost frequency
            oneLost.put(lost, oneLost.getOrDefault(lost, 0) + 1);

            // If our winners contain a loser, then just remove the loser
            if (winners.contains(lost)) {
                winners.remove(lost);
            }      
        }

        // noLost will contain all of the winners
        List<Integer> noLost = new ArrayList<>(winners);
        List<Integer> one = new ArrayList<>();

        // We only want to include the losers with only one lost and add it to our one Array List
        for(int key: oneLost.keySet() ) {
            if(oneLost.get(key) == 1) {
                one.add(key);
            }
        }

        // Sort them to be in order
        Collections.sort(noLost);
        Collections.sort(one);
        // Create out return value
        List<List<Integer>> retVal = new ArrayList<>();
        // Add them in the correct order
        retVal.add(noLost);
        retVal.add(one);
        // Return our arrayList
        return retVal;
    }
}