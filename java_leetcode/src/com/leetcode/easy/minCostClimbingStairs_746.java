package com.leetcode.easy;

public class minCostClimbingStairs_746 {

    //当前最低花费 = min{当前的前2步的min,当前的前1步的min}+当前的步数
    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0) return 0;
        int pre_2 = 0, pre_1 = 0;
        for (int i = 0; i <= cost.length; i++) {

            if (i == cost.length) {
                return Math.min(pre_2, pre_1);
            } else {
                int temp = pre_1;
                pre_1 = Math.min(pre_2, pre_1) + cost[i];
                pre_2 = temp;

            }
        }
        return pre_1;
    }

    public static int minCostClimbingStairs2(int[] cost) {
        if (cost.length == 0) return 0;
        int len = cost.length;
        int[] min = new int[len+2];
        min[0]=0;
        min[1]=0;
        for(int i=0;i<=len;i++){
            if(i==len)
                return Math.min(min[i],min[i+1]);
            else
                min[i+2] = Math.min(min[i],min[i+1])+cost[i];

        }
        return Math.min(cost[len+1],cost[len]);
    }




    public static void main(String[] args) {
        int[] cost = {1};
        System.out.println(minCostClimbingStairs(cost));
    }

}
