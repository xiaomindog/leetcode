package com.leetcode.easy;
/*给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
示例:
输入: [0,1,0,3,12]
输出: [1,3,12,0,0]*/

public class moveZeroes_283 {

    //执行用时 :18 ms, 在所有 Java 提交中击败了22.28%的用户
    //内存消耗 :38.6 MB, 在所有 Java 提交中击败了93.35%的用户
    public void moveZeroes(int[] nums) {
        if (nums.length <= 1) return;
        int i = 0;
        int j = 1;
        int t;
        int flag = 0; //做了交换的标志
        while (j < nums.length) {
            if (nums[i] == 0 && nums[j] == 0) {
                j++;
            } else if (nums[i] == 0) {
                t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i++;
                j = i + 1;
            } else {
                i++;
                j++;
            }
        }
    }

    //每次找到一个不为0的都赋值给数组 剩下的后面就全是0了
    public void moveZeroes2(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[k++] = nums[i];
        }
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    //记录0的个数 然后往前移
    public void moveZeroes3(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                nums[i - count] = nums[i];
            }
        }
        for (int i = nums.length-1;i>=nums.length-count;i--) {
            nums[i] = 0;
        }

    }
}
