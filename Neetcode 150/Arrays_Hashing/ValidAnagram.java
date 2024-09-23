// Two strings s and t

// Goal:

// - Return true if t is an anagram of s
// - Return false if the latter

// Anagram is where you can rearrange the letters of a word to form another word using the original letters

// Brute force, Take the word, sort them O(logn)
// Sorted in the same way, same occurences, same length
// Compare each character at i index, and see if it's the same

// O(logn * n)

// HashMap<Character, Integer>
// Character = key
// Integer = value = frequency

// TC: O(n)
// SC: O(l)
class Solution {
    public boolean isAnagram(String s, String t) {

        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }


        for(int values: map.values()) {
            if(values != 0) {
                return false;
            }
        }

        return true;
    }
}