package com.CK;

public class Main {

    public static void main(String[] args) {
        // write your code here
    }
}

class Solution {
    private static final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int r = matrix.length, c = matrix[0].length;
        int[][] dp = new int[r][c];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                max = Math.max(max, dfs(matrix, dp, i, j));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int[][] dp, int r, int c) {
        if (dp[r][c] != 0)
            return dp[r][c];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            int nextR = r + dir[i][0];
            int nextC = c + dir[i][1];
            if (isValid(matrix, nextR, nextC) && matrix[nextR][nextC] > matrix[r][c]) {
                max = Math.max(max, dfs(matrix, dp, nextR, nextC) + 1);
            }
        }
        dp[r][c] = max == Integer.MIN_VALUE ? 1 : max;
        return dp[r][c];
    }

    private boolean isValid(int[][] matrix, int r, int c) {
        return r < matrix.length && r >= 0 && c >= 0 && c < matrix[0].length;
    }
}