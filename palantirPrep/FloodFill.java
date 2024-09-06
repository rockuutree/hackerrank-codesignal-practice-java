// An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

// - m = row
// - n = columns

// You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].

// goal : flood fill on the image starting from the pixel image[sr][sc]
// - sr = starting row
// - sc = starting column

// Condition: Only applies to the same color as starting pixel
// pixels connected 4-directionally

// connected 4-directionally to those pixels
// - up 
// - down
// - left
// - right

// Replace all connected with color pixel

// Time Complexity: O(n * m)
// Space Complexity: O(n * m)
class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        // Simple edge case where if the grid is empty we just return the image
        if(!(image.length > 0)) {
            return image;
        }

        // Sets the initial value to the pixel given
        int initial = image[sr][sc];
        // Run a DFS fill
        fill(image, sr, sc, color, initial);

        return image;
    }

    private void fill(int[][] image, int row, int column, int color, int initial) {
        // Out of bounds edge case
        // Current pixel is not the initial edge case
        // The current pixel is the same color edge case
        if(row < 0 || row > image.length - 1|| column < 0 || column > image[0].length - 1|| image[row][column] != initial || color == image[row][column]) {
            return;
        }

        // Replaces the current pixel with the next color
        image[row][column] = color;
        // DFS recursive calls
        fill(image, row + 1, column, color, initial);
        fill(image, row - 1, column, color, initial);
        fill(image, row, column + 1, color, initial);
        fill(image, row, column - 1, color, initial);
    }


}