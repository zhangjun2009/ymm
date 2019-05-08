package com.zhangj.ymm.leetcode;

/**
 * @author zhangj
 * @date 2019/5/7
 * ==============
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * =================
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * ================
 */
public class LC200 {
    public static void main(String[] args) {
        int[][] grid = new int[4][5];
        grid[0][0] = 1;
        grid[0][1] = 1;
        grid[0][2] = 1;
        grid[0][3] = 1;
        grid[0][4] = 0;
        grid[1][0] = 1;
        grid[1][1] = 1;
        grid[1][2] = 0;
        grid[1][3] = 0;
        grid[1][4] = 0;
        grid[2][0] = 1;
        grid[2][1] = 1;
        grid[2][2] = 0;
        grid[2][3] = 0;
        grid[2][4] = 0;
        grid[3][0] = 0;
        grid[3][1] = 0;
        grid[3][2] = 0;
        grid[3][3] = 0;
        grid[3][4] = 0;
        System.out.println(count(grid));
    }

    public static int count(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int e = grid[i][j];
                if (e == 1) {
                    count++;
                    convertOne(grid, i, j);
                }
            }
        }
        return count;
    }

    private static void convertOne(int[][] grid, int i, int j) {
        int row = grid.length;
        int column = grid[0].length;
        if (i < 0 || i >= row || j < 0 || j >= column || grid[i][j] != 1) {
            return;
        }
        grid[i][j]=2;
        //上
        convertOne(grid, i - 1, j);
        //下
        convertOne(grid, i + 1, j);
        //左
        convertOne(grid, i, j - 1);
        //右
        convertOne(grid, i, j + 1);
    }
}
