package com.DP.backpack;

/**
 * **描述：**给定`n`种大小为 `A[i]`，值为 `V[i] `的物品，每个物品有 `amount[i]`
 * 个可用，一个大小为 `m` 的背包，你能放入背包的最大值是多少?
 */
public class backpack_7 {
    public static int backpackVII_1(int[] A, int[] V, int[] amount, int m) {
        int[][] dp = new int[A.length + 1][m + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= m; j++) {
                //dp[i][j] = dp[i - 1][j];
                for (int k = 0; k <= amount[i - 1]; k++) {
                    //k=0 表示当前元素不选
                    if (j >= k * A[i - 1]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * A[i - 1]] + k * V[i - 1]);
                    }
                }
            }
        }
        return dp[A.length][m];
    }

    public static int backpackVII_2(int[] A, int[] V, int[] amount, int m) {
        int[] dp = new int[m + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = m; j >= A[i - 1]; j--) {
                for (int k = 1; k <= amount[i - 1]; k++) {
                    if (j >= k * A[i - 1]) {
                        dp[j] = Math.max(dp[j], dp[j - k * A[i - 1]] + k * V[i - 1]);
                    }
                }
            }
        }
        return dp[m];
    }


    public static int backpackVII_3(int[] A, int[] V, int[] amount, int m) {
        int[] dp = new int[m + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int k = 0; k <= amount[i - 1]; k++) { //当前元素选择K个
                for (int j = m; j >= A[i - 1]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - A[i - 1]] + V[i - 1]);
                }
            }
        }

        return dp[m];
    }

    public static void main(String[] args) {
        int m = 8;
        int[] A = new int[]{2, 4};
        int[] V = new int[]{100, 100};
        int[] amount = new int[]{4, 2};
        System.out.println(backpackVII_3(A, V, amount, m));
    }
}
