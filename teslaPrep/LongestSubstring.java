// Given a string s, find the length of the longest 
// substring
//  without repeating characters.

// Sliding window
// - Increase the right side of the window until we reach a duplicate character
// - Once reach, we would move the left side of the window until our Hashmap holding the duplicate character is removed
// - HashMap to keep tracking of the frequency of the characters
// - Need a maxCount that will be returned
// - Comparing the window size

// Time complexity: O(n), while loop inside(for the left pointer) only moves at most n times, so forward)
// Space complexity: O(k)/O(1), the size of the character set, but with hashmap it could only contain at most O(26), which would mean this would be constant time.



class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Window that will hold the frequency of each character
        HashMap<Character, Integer> map = new HashMap<>();
        // Left + right pointers which will be the bounds of the window
        int left = 0;
        int right = 0;
        // Return value which will hold the longest substring without a repeat char
        int maxCount = 0;

        // Iterate until our window reachews the end
        while(right < s.length()) {
            // Intialize the next letter to be at the right pointer
            char rightLetter = s.charAt(right);

            // If our window contains the next letter, then that means theres a duplicate somewhere
            while(map.containsKey(rightLetter)) {
                // set the left letter to be at the character at the left pointer
                char leftLetter = s.charAt(left);
                // Decrease the frequency of the character found at the left pointer
                map.put(leftLetter, map.getOrDefault(leftLetter, 0) - 1);
                // If the frequency is 0, then we just want to remove it
                if(map.get(leftLetter) == 0) {
                    map.remove(leftLetter);
                }
                // increment the left pointer to the right
                left++;
            }
            // We put the character at the right pointer in the window/map
            map.put(rightLetter, map.getOrDefault(rightLetter, 0 ) + 1);
            // Max count is determined between the current count and the size of the current window
            maxCount = Math.max(maxCount, map.size());
            // Increment the right pointer to increase the window size
            right++;
        }
        // Return the max count;
        return maxCount;
    }
}