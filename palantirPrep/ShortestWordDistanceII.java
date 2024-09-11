// Time complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        // Return value
        int shortest = Integer.MAX_VALUE;
        // Hold both indicies
        int index1 = -1;
        int index2 = -1;
        // A flag to trigger if we have the same word
        boolean same = word1.equals(word2);


        for(int i = 0 ; i < wordsDict.length; i++) {
            // If we found a match
            if(wordsDict[i].equals(word1)) {
                // if we have the same word, we want to shift index2 to index1
                if(same) {
                    index2 = index1;
                }
                // Index1 will have the most recent matched value
                index1 = i;
                // If index2 has a valid index, then we find the shortest valuee
                if(index2 != -1) {
                    shortest = Math.min(shortest, Math.abs(index2 - index1));
                }
                // For cases where words arne't the same, set index2 to the most recent index
            } else if(wordsDict[i].equals(word2)) {
                index2 = i;
            }

            // For cases where the word isn;'t the same, we find the shortest this way.
            if(index1 != -1 && index2 != -1 && !same) {
                shortest = Math.min(shortest, Math.abs(index2 - index1));
            }

            
        }
        return shortest;
    }

}



/*

Better solution
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int index = -1;
        int shortest = wordsDict.length;
        boolean same = word1.equals(word2);

        for(int i = 0 ; i < wordsDict.length ; i++) {
            if(wordsDict[i].equals(word1) || wordsDict[i].equals(word2)) {
                if(index != -1 && (same || !wordsDict[index].equals(wordsDict[i]))) {
                    shortest = Math.min(i - index, shortest);
                }
                index = i; // index = 1
            }
        }

        return shortest;
    }

*/