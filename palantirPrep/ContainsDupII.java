// Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

// int[] nums and int k

// Goal: return true/false if nums[i] == nums[j] and the absolute value of i - j is <= k

// Time Complexity: O(n)

// Space Complexity: O(min(n, k)), our window will contain the minimum of n and k

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        // Create a sliding window where the set will always be below k
        Set<Integer> set = new HashSet<>();

        int i = 0;
        // If there's a duplicate within the window, then return true
        for(int j = 0; j < nums.length; j++) {
            if(set.contains(nums[j])) {
                return true;
                // Add to our set if we don't have a duplicate
            } else {
                set.add(nums[j]);
            }
            // Our check to ensure that our window stays within our k bounds
            if(set.size() >= k + 1) {
                set.remove(nums[i]);
                i++;
            }
        }

        return false;
    }
}

/*

My preferred solution tbh

Time Complexity: O(n)

Spaec Complexity: O(min(n, k))
public boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();

    for(int i = 0; i < nums.length; i++) {
        if(map.containsKey(nums[i])) {
            if(i - map.get(nums[i]) <= k) {
                return true;
            }
        }
        map.put(nums[i], i);
    }

    return false;
}


*/


