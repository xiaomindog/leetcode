package com.leetcode.easy;

import java.util.Arrays;

//图像渲染
public class floodFill_733 {
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length == 0 || image[0].length == 0) return new int[0][];
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
            return new int[0][];
        }
        int[][] temp = image.clone();
        dfs(temp, sr, sc, newColor, image[sr][sc]);
        return temp;
    }

    public static void dfs(int[][] image, int i, int j, int newColor, int num) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] == newColor || num != image[i][j]) {
            return;  //如果newColor和原来color一样，直接返回即可
        } else {
            int temp = image[i][j];
            image[i][j] = newColor;
            //image[i][j] = temp + 1;
            dfs(image, i + 1, j, newColor, temp);
            dfs(image, i - 1, j, newColor, temp);
            dfs(image, i, j + 1, newColor, temp);
            dfs(image, i, j - 1, newColor, temp);
            //image[i][j] = newColor;
        }
    }

    public static void main(String[] args) {
        int image[][] = new int[][]{{0, 0, 0}, {0, 1, 1}};
        int temp[][] = floodFill(image, 1, 1, 1);
        System.out.println(temp);
    }
}
