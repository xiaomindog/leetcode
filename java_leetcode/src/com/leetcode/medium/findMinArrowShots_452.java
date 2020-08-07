package com.leetcode.medium;

import java.util.Arrays;

/**
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。
 * 由于它是水平的，所以y坐标并不重要，因此只要知道开始和结束的x坐标就足够了。
 * 开始坐标总是小于结束坐标。平面内最多存在104个气球。
 * 一支弓箭可以沿着x轴从不同点完全垂直地射出。在坐标x处射出一支箭，
 * 若有一个气球的直径的开始和结束坐标为 xstart，xend，
 * 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。
 * 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 * Example:
 * 输入:
 * [[10,16], [2,8], [1,6], [7,12]]
 * 输出:
 * 2
 * 解释:
 * 对于该样例，我们可以在x = 6（射爆[2,8],[1,6]两个气球）和 x = 11（射爆另外两个气球）。
 */
public class findMinArrowShots_452 {

    //贪心算法 ————代码精简：按y升序排序，每次爆最右边的
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        //按照y坐标升序排序
        Arrays.sort(points, (t1, t2) -> t1[1] - t2[1]);
        int m = 1;
        int end = points[0][1];
        for (int i = 0; i < points.length; i++) {
            if (end < points[i][0]) {
                m++;
                end = points[i][1];  //只要更新end即可
            }
        }
        return m;
    }

    public int findMinArrowShots_1(int[][] points) {
        if (points.length == 0) return 0;
        //按照x坐标升序，y坐标降序排序
        Arrays.sort(points, (t1, t2) -> t1[0] == t2[0] ? t2[1] - t1[1] : t1[0] - t2[0]);
        int m = 1;
        int tmp[] = points[0];
        for (int i = 1; i < points.length; i++) {
            if (tmp[1] < points[i][0]) {
                tmp = points[i];
                m++;//如：[1,2] ,[3,4]  2<3
            } else {
                tmp[0] = points[i][0]; //因为是x升序的 所以tmp[0]保存的较大的一个
                tmp[1] = Math.min(tmp[1], points[i][1]); //tmp[1]保存较小的一个
            }
        }
        return m;
    }
}
