package com.DP.backpack;

/**
 * 给定`n`种大小为`Ai`，值为`Vi`的物品(每个物品都有无限多的可用物品)和一个大小为m的背包，
 * 你能放入背包的最大值是多少?
 */
public class backpack_3 {
    //思路：视为特殊的多重背包问题 每个物品的个数的最大为m/A[i]
    public static int backPackIII_1(int m, int[] A, int[] V) {
        if (m == 0 || A.length == 0 || V.length == 0) return 0;
        int[][] dp = new int[A.length + 1][m + 1];

        for (int i = 1; i <= A.length; i++) {
            for (int j = A[i - 1]; j <= m; j++) {
                dp[i][j] = dp[i - 1][j]; //第i个不选
                for (int k = 1; k * A[i - 1] <= m; k++) {
                    if (j >= k * A[i - 1]) { //当前第i个情况不选(k=0) 或者选k个
                        dp[i][j] = Math.max(dp[i][j],
                                dp[i - 1][j - k * A[i - 1]] + k * V[i - 1]);
                    }
                }
            }
        }
        return dp[A.length][m];
    }

    //多重背包问题解完全背包问题的DP优化
    public static int backPackIII_2(int m, int[] A, int[] V) {
        if (m == 0 || A.length == 0 || V.length == 0) return 0;
        int[] dp = new int[m + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int k = 1; k * A[i - 1] <= m; k++) {  //遍历当前该元素的个数
                for (int j = m; j >= A[i - 1]; j--) {
                    //当前元素 不取 或者取1个
                    dp[j] = Math.max(dp[j], dp[j - A[i - 1]] + V[i - 1]);
                }
            }
        }
        return dp[m];
    }


    //另一种思路 同leetcode518 零钱兑换II
    public static int backPackIII_3(int m, int[] A, int[] V) {
        if (m == 0 || A.length == 0 || V.length == 0) return 0;
        int[] dp = new int[m + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = A[i - 1]; j <= m; j++) {
                //对于当前物品i，若j从小到大的话，很可能在j之前的j-A[i-1]时已经放过第i件物品了，
                // 在j时再放就是重复放入；若j从大到小，则j之前的所有情况都没有更新过，
                // 不可能放过第i件物品，所以不会重复放入。 //与第二题相反
                dp[j] = Math.max(dp[j], dp[j - A[i - 1]] + V[i - 1]);
            }
        }
        return dp[m];
    }


    public static void main(String[] args) {
        int m = 10;
        int A[] = new int[]{3, 4, 8, 5}; //[3,4,8,5]{2, 4, 5, 6}
        int V[] = new int[]{1, 5, 2, 4};
        System.out.println(backPackIII_2(m, A, V));
    }
}
