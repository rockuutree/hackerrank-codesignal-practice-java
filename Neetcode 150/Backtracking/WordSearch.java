// m x n grid of characters board

// Run a dfs, check if the starting character of the word, has neighboring nodes which represents the next character in the word
// string "word"
//  return true if "word" exists in the grid

// TC: O(m * n)
// SC: O(m * n + L)


class Solution {

    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if(word != "" && board.length < 0) {
            return false;
        }
        // Creates a visited board
        visited = new boolean[board.length][board[0].length];
        
        // Visit each cell
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                // If we find the starting character, then we search from there
                if(word.charAt(0) == board[i][j] && dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Index is what character in the word we're currently at
    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        // If we find all the characters in the word then we return true
        if(index == word.length()) {
            return true;
        }
    
    // If we're out of bounds or the next character is not the character we want, then return false;
    if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]) {
        return false;
    }

    // Marks each character as visited
    visited[i][j] = true;

    // If one pathway reaches the end, then we return true overall
    if( dfs(board, word, i + 1, j, index + 1) || 
        dfs(board, word, i - 1, j, index + 1) ||
        dfs(board, word, i, j + 1, index + 1) ||
        dfs(board, word, i, j - 1, index + 1)
    ) {
        return true;
    }

    // Unmark if we don't return true that way we can reuse the characters pathway.
    visited[i][j] = false;
    return false;

    }


}