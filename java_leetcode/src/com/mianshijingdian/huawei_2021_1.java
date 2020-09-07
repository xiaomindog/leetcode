package com.mianshijingdian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class huawei_2021_1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入n和m：");
        int n = sc.nextInt(), m = sc.nextInt();
        double[][][] ans = new double[n][m][3];
        System.out.println("输入网格数组：");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 3; k++) {
                    ans[i][j][k] = sc.nextDouble();
                }
            }
        }


    }
}
