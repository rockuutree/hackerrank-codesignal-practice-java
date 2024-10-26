// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]

// - 1,3 overlaps with 2,6
// - Ending of the first interval, which is (3) > (2) start of second interval -> overlaps

// - [Start of first , End of second] -> int[][] retVal


// intervals[i].length == 2 -> < 2 in single array

// Time Complexity: O(n log n), sort then interate through intervals
// Space Complexity: O(n), if worstcase nothing merges then ArrayList will contain n

class Solution {
    public int[][] merge(int[][] intervals) {

        // Sort the array to ensure that the starting values are in correct order
        // Use Lambda function to determine the sorting
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Create an ArrayList<int[]> so that we can add it to an array of array quickly
        ArrayList<int[]> retVal = new ArrayList<>();

        // Intialize outside of the forloop because we will be adding in the last value outside of the forloop
        int start1 = intervals[0][0];
        int end1 = intervals[0][1];

        for(int i = 1; i < intervals.length; i++) {
            
            // Intiliaze the next array set
            int start2 = intervals[i][0];
            int end2 = intervals[i][1];

            // If the end of the first array is greater or equal to the start of the second array, then they overlap
            if(end1 >= start2) {
                // Set the end to the greater end
                end1 = Math.max(end1, end2);
            } else {
                // If they are in correct order, then we add to the arraylist
                retVal.add(new int[]{start1, end1});
                // Move the current start/end to the next start/end
                start1 = start2;
                end1 = end2;
            }

        }
        // We want to add to always add the final array outside because in the forloop it comapares the first and next.
        retVal.add(new int[]{start1, end1});
        // Converts the arraylist to an int[][]
        return retVal.toArray(new int[retVal.size()][]);   
    }
}