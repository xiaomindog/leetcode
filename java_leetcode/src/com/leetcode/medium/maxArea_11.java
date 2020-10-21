package com.leetcode.medium;


/**给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
说明：你不能倾斜容器，且 n 的值至少为 2。o
**/
public class maxArea_11 {
    public static int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int max = 0;

        while (i < j) {
            int t = Math.min(height[i], height[j]) * (j - i);
            if (max < t) max = t;

            if (height[i] > height[j]) {
                j--;
            } else if (height[i] < height[j]) {
                i++;
            } else { //两端相等的情况 比较各自的下一个 下一个大的则移动
                if (height[i + 1] > height[j - 1] && (i + 1 < j - 2)) {
                    i++;
                } else if (height[i + 1] < height[j - 1] && (i + 1 < j - 2)) {
                    j--;
                } else {
                    i++;
                }
            }

        }
        return max;

    }

    //改进上面的这个算法 实际上当存在2个相同的时候 最大的那个边界肯定不是他们中的了
    public static int maxArea2(int[] height) {
        int i = 0, j = height.length - 1;
        int max = 0;
        while (i < j) {
            max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            if(height[i]<height[j]){
                i++;
            }else {
                j--;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] s = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(s));
    }

}
