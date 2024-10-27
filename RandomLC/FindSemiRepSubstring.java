// Given a String s
// - Digits consist of 0-9

// A string is semi-repetitive if there is AT MOST one adjacent pair of the same digit

// TC: O(n)
// SC: O(1)
class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        char[] list = s.toCharArray();
        int l = 0;
        int r = 1;
        boolean foundPair = false;
        int dupIndex = 0;

        // 
        int length = 0;
        int max = 0;
        if(s.length() == 1) {
            return 1;
        }

        while(r < list.length ) {
            if(list[r-1] == list[r] && foundPair) { // 0 == 1 r = 3

                while(l < dupIndex) {
                    l++; // l = 1
                    
                }
                dupIndex = r;
                r++; // 3
            } else {
                if(list[r] == list[r-1]) {
                    foundPair = true;
                    dupIndex = r;
                }
                r++; // r = 4
            }
            length = r - l; // 2

            max = Math.max(max, length); // 2
        }

        return max;
        
    }
}