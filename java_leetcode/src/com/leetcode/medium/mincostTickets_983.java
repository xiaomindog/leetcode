package com.leetcode.medium;

/*
* 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。
* 每一项是一个从 1 到 365 的整数。
火车票有三种不同的销售方式：
一张为期一天的通行证售价为 costs[0] 美元；
一张为期七天的通行证售价为 costs[1] 美元；
一张为期三十天的通行证售价为 costs[2] 美元。
通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：
* 第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
*/


public class mincostTickets_983 {
    public int mincostTickets(int[] days, int[] costs) {

        if (days.length == 0) return 0;
        int allDays = days[days.length - 1];
        int dp[] = new int[allDays + 1];
        for (int i = 0; i < days.length; i++) {
            dp[days[i]] = 1; //当天需要出行的标记
        }

        for (int i = 1; i <= allDays; i++) { //第几天出行
            if (dp[i] == 0) {
                dp[i] = dp[i - 1]; //如果当天不出行 花费和前一天相同
            } else {
                int a, b, c;
                a = dp[i - 1] + costs[0];

                if (i - 7 >= 0) {
                    b = dp[i - 7] + costs[1];
                } else {
                    b = costs[1];
                }
                if (i - 30 >= 0) {
                    c = dp[i - 30] + costs[2];
                } else {
                    c = costs[2];
                }
                dp[i] = Math.min(a, b);
                dp[i] = Math.min(c, dp[i]);
            }
        }
        return dp[dp.length - 1];
    }


}
