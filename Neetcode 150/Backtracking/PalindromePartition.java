// Input: String s
// "Partition s" such that every substring of the partition is a palindrome
// Palindrome is a word that reads the same backwards
// Return all possible palindroms partitioning of s

// TC: O(n * 2^n)
// SC: O(n * 2^n)

class Solution {
    List<List<String>> retVal;
    public List<List<String>> partition(String s) {
        retVal = new ArrayList<>();

        // run backtracking on s

        backtrack(s, 0, new ArrayList<>());

        return retVal;
    }   

    private void backtrack(String s, int start, List<String> curPartition ) {
        // If we reach the end of the string, add the current partition to the return value
        if(start == s.length()) {
            retVal.add(new ArrayList<>(curPartition));
            return;
        }

        // Loops through every possible end positions for the current partition
        for(int i = start; i <= s.length() - 1; i++) {

            String substring = s.substring(start, i + 1);

            // If the current substring is a palindrome then we want to proceed
            if(isPalindrome(substring)) {
                // Adds the substring to our list of palindrome substrings within our partition
                curPartition.add(substring);
                // Go to the next index of the string
                backtrack(s, i + 1, curPartition);
                // Remove the last substring in our partion
                curPartition.remove(curPartition.size() - 1);
            }
        }

    }
        
    // Helper method to determine a palindrome
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}