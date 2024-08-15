package tiktok;

import java.util.*;

public class MinimumBuckets {
    
    public static int minimumBuckets(int[] arr) {
        
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int buckets = 0;

        for (int frequency: frequencyMap.values()) {
             buckets += (int) Math.ceil((double) frequency / (Math.floor(frequency / 2.0) + 1));
        }

        return buckets;

    }

    public static void main(String[] args) {
        // Example usage
        int[] arr = {1, 2, 2, 3, 4};
        System.out.println("Minimum buckets required: " + minimumBuckets(arr));
    }
}
