package tiktok;

public class CompletingTasks {
    
    public static int minimumTime(int n, int[] data) {
        int m = data.length;
        
        // Array to store the time taken by each user to complete their assigned tasks.
        int[] time = new int[n];

        // Iterate over each task and assign it to the user who is proficient in it.
        for (int i = 0; i < m; i++) {
            int userIndex = data[i] - 1; // Converting 1-based index to 0-based
            if (userIndex == i) {
                time[userIndex] += 1; // Task is assigned to the proficient user, so 1 minute
            } else {
                time[userIndex] += 2; // Task is assigned to a non-proficient user, so 2 minutes
            }
        }

        // The result will be the maximum time any user takes to complete their tasks
        int result = 0;
        for (int t : time) {
            result = Math.max(result, t);
        }

        return result;
    }

    public static void main(String[] args) {
        // Sample Case 1
        int n1 = 3;
        int[] data1 = {1, 2, 3, 2, 2, 2};
        System.out.println("Sample Case 1:");
        System.out.println("Input: n = " + n1 + ", data = " + java.util.Arrays.toString(data1));
        System.out.println("Output: " + minimumTime(n1, data1));
        System.out.println();

        // Sample Case 2
        int n2 = 2;
        int[] data2 = {1, 1, 2, 2, 2};
        System.out.println("Sample Case 2:");
        System.out.println("Input: n = " + n2 + ", data = " + java.util.Arrays.toString(data2));
        System.out.println("Output: " + minimumTime(n2, data2));
    }
}
