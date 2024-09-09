Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.


Most optimal is using the XOR, but like realistically who wants to use XOR lol

Time Complexity: O(n)

Space Complexity: O(n)

class Solution {
    public int singleNumber(int[] nums) {

        // Creates a set to contain our numbers
        Set<Integer> set = new HashSet<>();

        // Loops through the nums
        for(int num: nums) {
            // If we already have the number in our set, then just remove it
            if(set.contains(num)) {
                set.remove(num);
            } else {
                // Otherwise add it
                set.add(num);
            }
        }
        // Should be left with one number left, so we would want to use

        // set.iterator().next()
        // Iterator converts it to an ordered list, and .next gets literally the next available element.

        return set.iterator().next();
    }
}