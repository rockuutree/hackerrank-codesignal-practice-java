package tiktok;
import java.util.*;

public class ThreeKnightsProblem {
    private static int count = 0;
    private static final int[][] moves = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

    public static int countPlacements(int n, int m) {
        count = 0;
        boolean[][] board = new boolean[n][m];
        placeKnights(board, 0, 0, 3);
        return count;
    }

    private static void placeKnights(boolean[][] board, int row, int col, int knightsLeft) {
        if (knightsLeft == 0) {
            count++;
            return;
        }

        for (int i = row; i < board.length; i++) {
            for (int j = (i == row ? col : 0); j < board[0].length; j++) {
                if (canPlace(board, i, j)) {
                    board[i][j] = true;
                    placeKnights(board, i, j + 1, knightsLeft - 1);
                    board[i][j] = false;
                }
            }
        }
    }

    private static boolean canPlace(boolean[][] board, int row, int col) {
        for (int[] move : moves) {
            int newRow = row + move[0];
            int newCol = col + move[1];
            if (isValid(board, newRow, newCol) && board[newRow][newCol]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(boolean[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n (number of rows): ");
        int n = scanner.nextInt();
        System.out.print("Enter m (number of columns): ");
        int m = scanner.nextInt();

        int result = countPlacements(n, m);
        System.out.println("Number of possible placements: " + result);
    }
}