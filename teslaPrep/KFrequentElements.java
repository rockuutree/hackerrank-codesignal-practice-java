// Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
// - Return an integer array that contains the most frequent elements
// - The most frequency elements are maxed out at k
// - Need something to count the amount of frequency of a certain number

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Create a hashmap to count the frequency of number within nums
        HashMap<Integer, Integer> map = new HashMap<>();

        // Filling up the hashmap which will run at O(n)
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // Create a maxheap, where the greater value within the map will be at the front/top
        // Priority queue implements a min-heap by default, but to create a max heap, you would pass in thus custom comparator rule 
        // A comparator is passed in as a lambda function for how the heap should sort the element.
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for(int num: map.keySet()) {
            heap.add(num);
            System.out.println(heap);
        }
        // Create the return value array
        int[] retVal = new int[k];
        // Take the k amount of numbers from the heap front/top using poll();
        for(int i = 0; i < k; i++) {
            retVal[i] = heap.poll();
        }
        return retVal;
    }
}