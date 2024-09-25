// String[] strs
// Goal: Group anagrams together, List<List<String>>, each subgroup are anagrams of eachother
// Add that subgroup into our total list

// Anagram -> they contain exactly all the same characters 

// Sort each character in strs
// Create HashMap<String, List<String>>
// Key = the sorted string in strs
// Value = grouping of anagrams

// TC: O(n * logn)
// SC: O(n)

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Key = Sorted string
        // Value = Grouping of anagrams
        HashMap<String, List<String>> map = new HashMap<>();

        List<List<String>> retVal = new ArrayList<>();

        // Loop to strs array
        for(String str: strs) {
            // Sort each word but converting it to a list of chars, sort then back to a String
            char[] list = str.toCharArray();
            Arrays.sort(list);
            String sorted = new String(list);

            // If the map doesn't have the sorted word
            if(!map.containsKey(sorted)) {
                // Intiailize an empty list
                map.put(sorted, new ArrayList<>());
            } 
            // Always adding the word (not sorted) to the end of the array list
            map.get(sorted).add(str);
        }


        // converts the hashmap to arrayList
        return new ArrayList<>(map.values());
    }
}