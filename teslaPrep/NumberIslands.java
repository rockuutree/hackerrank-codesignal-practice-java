// Time comeplexity is O(m * n)
// Space complexity is O(m * n)

class Solution {
    // Store the rows
    private int n;
    // Store the columns in the grid
    private int m;

    public int numIslands(char[][] grid) {
        // Count for the number of islands
        int count = 0;
        // Initialize n to rows
        n = grid.length;
        // Returns 0 if grid is empty
        if (n == 0 ) {
            return 0;
        }
        // Set m to columns
        m = grid[0].length;

        // Iterate through the grid
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                // Nested for loop goes through each cell in the grid and when it finds 1(land) it calls the DFSMarking and increnets count
                if(grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    // DFS Search method
    private void DFSMarking(char[][] grid, int i, int j) {
        // Checks ift he current position is out of bounds or not 1
        // If so, then it returns
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') {
            return;
        }
        // If it's a valid '1', we change it to '0' to mark it as visited
        grid[i][j] = '0';
        // Recursively calls itself on the four adjacent cells
        // DFS Floods the entire island and marks all connected 1s as 0s.
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }
}