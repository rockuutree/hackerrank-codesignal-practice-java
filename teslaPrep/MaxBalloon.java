// Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

// - count as many instances

// You can use each character in text at most once. Return the maximum number of instances that can be formed.

// - Can only use the characters once
// - Return the count


class Solution {
    public int maxNumberOfBalloons(String text) {
        // Create a hashmap to count the frequency of the letters
        HashMap<Character, Integer> map = new HashMap<>();
        // Our count will be set to the max, because the lowest count of a letter will mean there will only be certain number of instances found. Accounts for a lot more of a certain letter.
        int count = Integer.MAX_VALUE;
        // Loops through the string text
        for(int i = 0; i < text.length()  ;i++) {
            // Letter is set to ith index
            char letter = text.charAt(i);
            // Check if the letter consists of one of the key letters in balon
            if(letter == 'b' ||letter == 'a' ||letter == 'l' ||letter == 'o' ||letter == 'n') {
                // Puts the letter in the map and increases the frequency
                map.put(letter, map.getOrDefault(letter, 0) + 1);
            }
        }
        
        // If we don't have all 5 letters, then that means that there isn't a complete instance
        if(map.size() != 5) {
            count = 0;
            // Return count as 0 because no ballon instances were found
        } else {
            // Checks each key and updates count based on the lowest frequency of a character
            for(Character ch : map.keySet()) {
                // Counts for l and o which have more than one letter in balloon, so we would have to divide by 2
                if(ch == 'l' || ch == 'o') {
                    count = Math.min(count, map.get(ch) / 2);
                } else {
                    // Otherwise we just check it regularly.
                    count = Math.min(count, map.get(ch));
                }
            }
        }

    return count;
    }
}