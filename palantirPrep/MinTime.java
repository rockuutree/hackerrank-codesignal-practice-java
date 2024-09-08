// Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list.

// - Goal: return the MINIMUM minutes difference between any time - points. -> One value minimum between the whole list
// - Conver hours to minutes

// Constraints:

// - We would always have two in the list

// - timePointers[i] HH:MM

// HH < 24

// MM < 60

// Time Complexity: O(n log n) , sort + iterate through timePoints

// Space Complexity: O(n)

class Solution {
    public int findMinDifference(List<String> timePoints) {
        // Minimum needs to be set to max value
        int minimum = Integer.MAX_VALUE;
        // int[] array to hold out times when converted from String -> int
        int[] times = new int[timePoints.size()];

        // For loop to add to our time array from our timePoints;
        for(int i = 0; i < timePoints.size(); i++) {
            String[] s = timePoints.get(i).split(":");
            times[i] = convertMinutes(s);
        }

        // Sorting our time array to be in order from least to Greatest
        Arrays.sort(times);

        // Compares the current number with the previous one in the array and check for the minimum
        for(int i = 1; i < timePoints.size(); i++) {
            minimum = Math.min(minimum, times[i] - times[i - 1]);
        }
        // Special test case with the greatest and least where 23:59 and 00:00 would be one
        // Subtracts the greatest from 24*60 + the least to see the minimum
        minimum = Math.min(minimum, times[0] + (24*60 - times[timePoints.size() - 1]));
        return minimum;

    }

    // private function to convert the string time to minutes
    private int convertMinutes(String[] arr) {
        int retVal = ((Integer.parseInt(arr[0])) * 60) + Integer.parseInt(arr[1]);
        return retVal;
    }

}