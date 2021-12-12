package dev.jessehaniel;

public class NumberOfIslands {

    // https://leetcode.com/problems/number-of-islands/
    //
    // Given an m x n 2D binary grid `grid` which represents a map of '1's (land) and '0's (land),
    // the number of islands.
    // An island is surrounded by land and is formed by connecting adjacent lands horizontally or vertically.
    // You may assume all four edges of the grid are all surrounded by land.

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int cont = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    cont++;
                    // Once you have found an island, consider any other connected island as water.
                    // Then you will have in the grid just the unique islands.
                    visitElement(grid, i, j);
                }
            }
        }
        return cont;
    }

    private void visitElement(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        visitElement(grid, i, j + 1);
        visitElement(grid, i, j - 1);
        visitElement(grid, i + 1, j);
        visitElement(grid, i - 1, j);
    }

    public static void main(String[] args) {
        final NumberOfIslands app = new NumberOfIslands();
        char[][] grid1 =
            {{'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}};
        System.out.println(app.numIslands(grid1));//1
        char[][] grid2 =
            {{'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}};
        System.out.println(app.numIslands(grid2));//3
        char[][] grid3 =
            {{'1', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0'},
            {'1', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}};
        System.out.println(app.numIslands(grid3));//4
        char[][] grid4 =
            {{'1', '0', '0', '0', '1'},
            {'1', '0', '0', '0', '1'},
            {'1', '0', '0', '0', '1'},
            {'1', '0', '0', '0', '1'}};
        System.out.println(app.numIslands(grid4));//2
    }

}
