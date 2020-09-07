package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 示例 1:
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
 * 提示：
 * intervals[i][0] <= intervals[i][1]
 */
public class merge_56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];
        Arrays.sort(intervals, (t1, t2) -> t1[0] - t2[0]);
        List<int[]> ans = new ArrayList<>();
        int i = 0, j = 0;
        while (i < intervals.length) {
            int t = intervals[i][1];
            while (j < intervals.length && t >= intervals[j][0]) {
                t = Math.max(t, intervals[j][1]);
                j++;
            }
            ans.add(new int[]{intervals[i][0], t});
            i = j;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
