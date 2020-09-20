package com.DP.backpack;

/**
 * 你总共有n 万元，希望申请国外的大学，要申请的话需要交一定的申请费用，
 * 给出每个大学的申请费用以及你得到这个大学offer的成功概率，大学的数量是 m。
 * 如果经济条件允许，你可以申请多所大学。找到获得至少一份工作的最高可能性。
 * 样例 1:
 * 输入:
 * n = 10
 * prices = [4,4,5]
 * probability = [0.1,0.2,0.3]
 * 输出:  0.440
 * 解释：
 * 选择第2和第3个学校。
 * <p>
 * 样例 2:
 * 输入:
 * n = 10
 * prices = [4,5,6]
 * probability = [0.1,0.2,0.3]
 * 输出:  0.370
 * 解释:
 * 选择第1和第3个学校。
 */
public class backpack_9 {
    /**
     * 代码思路
     * 1. 定义一个二维数组dp[i]来表示花费i万元申请学校一所都没录取的概率
     * 2. 初始化dp数组，先假设录取概率都为0
     * 3. 操作probability数组，变成未录取的概率 probability[i] = 1.0 - probability[i]
     * 4. 第一层循环枚举i表示申请前i个学校
     * 5. 第二层循环枚举j表示花费j万元
     * 6. 根据算法思路中的状态转移方程来实现 dp[j] = min(dp[j],dp[j-prices[i]] * probability[i])
     * 7. dp[n]表示花费 n 万元一所学校都未录取的最小概率
     */


    //转换成01背包来想： 有n个学校，每个学校都不录取的值为Vi，求一所学校都没录取的最小值
    public static double backpackIX_1(int n, int[] prices, double[] probability) {
        double[][] dp = new double[prices.length + 1][n + 1];
        for (int i = 0; i <= prices.length; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = 1.0;
            }
        }
        for (int i = 0; i < probability.length; i++) {
            probability[i] = 1.0 - probability[i];
        }
        for (int i = 1; i <= prices.length; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= prices[i - 1]) { //选择当前学校
                    dp[i][j] = Math.min(dp[i - 1][j],
                            dp[i - 1][j - prices[i - 1]] * probability[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return 1 - dp[prices.length][n];
    }

    public static double backpackIX_2(int n, int[] prices, double[] probability) {
        double[] dp = new double[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = 1.0;
        }
        for (int i = 0; i < probability.length; i++) {
            probability[i] = 1.0 - probability[i];
        }
        for (int i = 1; i <= prices.length; i++) {
            for (int j = n; j >= prices[i - 1]; j--) {
                dp[j] = Math.min(dp[j], dp[j - prices[i - 1]] * probability[i - 1]);
            }
        }
        return 1 - dp[n];
    }


    public static void main(String[] args) {
        int n = 6595;
        int[] prices = new int[]{178, 4933, 9772, 4890, 1732, 1690, 3793};
        double[] weight = new double[]{0.1, 0.8, 0.8, 0.1, 0.2, 0.2, 0.8};
        System.out.println(backpackIX_1(n, prices, weight));
    }
}
