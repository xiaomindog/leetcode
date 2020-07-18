package com.jianzhi;

import java.util.LinkedList;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 */
public class findContinuousSequence_57_II {

    //双指针
    //我们用两个指针l和r表示当前枚举到的以l为起点到r的区间，sum表示[l,r]的区间和
    // 起始 l=1,r=2。
    public static int[][] findContinuousSequence(int target) {
        List<int[]> list = new LinkedList<>();
        int l = 1, r = 2;
        while (l < r) {
            int sum = (l + r) * (r - l + 1) / 2; //等差数列求和公式
            if (sum == target) {
                int ans[] = new int[r - l + 1];
                for (int m = l, x = 0; m <= r; m++) {
                    ans[x++] = m;
                }
                list.add(ans);
                l++;
            } else if (sum > target) {
                l++;
            } else {
                r++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    //暴力法 滑动窗口
    //确定数组的上下界 下界为1 上界为 target/2
    public static int[][] findContinuousSequence_1(int target) {
        List<int[]> list = new LinkedList<>();
        int left = 1, right = target / 2;
        for (int i = left; i <= right; i++) {
            int sum = 0;
            int j;
            for (j = i; sum < target; j++) {
                sum += j;
            }
            if (sum == target) {
                int ans[] = new int[j - i + 1];
                for (int x = i, m = 0; x < j; x++) {
                    ans[m++] = x;
                }
                list.add(ans);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] a = findContinuousSequence(9);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i][0]);
        }
    }
}
