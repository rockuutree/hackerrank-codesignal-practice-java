// You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

// coordinates[i] = [x, y]

// x = coordinates[i][0];
// y = coordinates[i][1];

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {

        // Find the slope for the x and y values
        int dx = coordinates[1][0] - coordinates[0][0];
        int dy = coordinates[1][1] - coordinates[0][1];


        // Start at 2, because we looked at 0-1 indicies already
        for(int i = 2; i < coordinates.length; i++) {
            // Finds the current differences
            int current_dx = coordinates[i][0] - coordinates[0][0];
            int current_dy = coordinates[i][1] - coordinates[0][1];

            // Cross multiple, if they were equal then they would be the same;
            if (dy * current_dx != dx * current_dy) {
                return false;
            }
        }
        return true;
    }


}