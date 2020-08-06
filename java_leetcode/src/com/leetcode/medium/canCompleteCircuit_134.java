package com.leetcode.medium;

/***在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。
 你从其中的一个加油站出发，开始时油箱为空。
 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 说明: 
 如果题目有解，该答案即为唯一答案。
 输入数组均为非空数组，且长度相同。
 输入数组中的元素均为非负数。
 */
public class canCompleteCircuit_134 {


    //一次遍历法，车能开完全程需要满足两个条件：
    //1.车从i站能开到i+1。
    //2/ 所有站里的油总量要>=车子的总耗油量。
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0) return -1;
        int oil = 0, run = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            oil += (gas[i] - cost[i]);
            run += (gas[i] - cost[i]);
            if (run < 0) {
                start = i + 1;
                run = 0;
            }
        }
        if (oil >= 0) return start;
        return -1;
    }

    //参考题解：https://leetcode-cn.com/problems/gas-station/solution/
    // shuang-zhi-zhen-fa-shi-jian-fu-za-du-onkong-jian-f/
    //这个思路比较难想到
    public int canCompleteCircuit_2(int[] gas, int[] cost) {
        if (gas.length == 0) return -1;
        int len = gas.length;
        int oil = gas[0];
        int start = 0, cur = 0; //起点为0，当前为0
        while ((cur + 1) % len != start) {
            if (oil >= cost[cur]) {
                //当前油足够到下一个加油站
                oil -= cost[cur];
                cur = (cur + 1) % len;
                oil += gas[cur];
            } else { //当前start出发 到cur已经无法继续下去
                start = (len + start - 1) % len;
                oil -= cost[start];  //重新选择start结点，并且保留了前面计算过的oil
                oil += gas[start];
            }
        }
        //检查一下最后的cur能否返回start
        if (oil >= cost[cur]) return start;
        return -1;
    }

    //O(n2)解法 暴力
    public int canCompleteCircuit_1(int[] gas, int[] cost) {
        for (int start = 0; start < gas.length; start++) {
            int oil = 0;
            int i = start;

            while (i - start < gas.length) {
                if (i < gas.length) {
                    oil += gas[i];
                    oil -= cost[i];
                } else {
                    oil += gas[i - gas.length];
                    oil -= cost[i - gas.length];
                }
                i++;
                if (oil < 0) break;
            }

            if (oil >= 0) return start;
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
