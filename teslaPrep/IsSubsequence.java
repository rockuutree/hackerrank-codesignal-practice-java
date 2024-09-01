// Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
// - Want to check if s will be a subsequence of t, so s will usually be less than t
// - True if s is, false if not

// A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

// - Needs to maintain its original positions. So it's not a subsequence if the word is arrange to be the same.
// - ace isSub of abcde
// - aec !isSub of abcde

// Create a pointer for both strings and basically iterate until we reach the end of s

// Time complexity = O(n)
//  Space Complexity = O(1)
class Solution {
    public boolean isSubsequence(String s, String t) {
        // Two pointer to iterate between both strings
        int sPointer = 0;
        int tPointer = 0;

        // Loops until we reach end of a word (Will likely be s)
        while (sPointer < s.length() && tPointer < t.length()) {
            // Compares both characters at the index
            if(s.charAt(sPointer) == t.charAt(tPointer)) {
                // Only iterate sPointer if a match is found
                sPointer++;
            }
            // Automatically return true if sPointer is == to s.length() because that means we found the subsequence
            if(sPointer == s.length()) {
                return true;
            }
            // We always want to iterate tPointer because we will be checking the t and seeing if we have s in there
            tPointer++;
        }

        return sPointer == s.length();
    }
}