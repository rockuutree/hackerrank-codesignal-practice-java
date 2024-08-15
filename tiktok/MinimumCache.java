package tiktok;
import java.util.*;

public class MinimumCache {
    public static int getMinimumSize(String[] requests, int k) {
        int n = requests.length;
        if (k > n) return -1;

        for (int size = 1; size <= n; size++) {
            int hits = 0;
            Set<String> cache = new LinkedHashSet<>();

            for (String request : requests) {
                if (cache.remove(request)) {
                    hits++;
                } else if (cache.size() == size) {
                    Iterator<String> it = cache.iterator();
                    it.next();
                    it.remove();
                }
                cache.add(request);

                if (hits == k) {
                    return size;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // Test Case 1 (from the image)
        String[] requests1 = {"item3", "item2", "item1", "item2", "item3"};
        int k1 = 1;
        System.out.println("Test Case 1 Output: " + getMinimumSize(requests1, k1));
        // Expected output: 2

        // Test Case 2 (from the image)
        String[] requests2 = {"item1"};
        int k2 = 1;
        System.out.println("Test Case 2 Output: " + getMinimumSize(requests2, k2));
        // Expected output: -1

        // Additional Test Case 3
        String[] requests3 = {"item1", "item2", "item3", "item4", "item1", "item2", "item3", "item4"};
        int k3 = 4;
        System.out.println("Test Case 3 Output: " + getMinimumSize(requests3, k3));
        // Expected output: 4

        // Additional Test Case 4
        String[] requests4 = {"item1", "item1", "item1", "item2", "item2", "item3"};
        int k4 = 3;
        System.out.println("Test Case 4 Output: " + getMinimumSize(requests4, k4));
        // Expected output: 2
    }
}