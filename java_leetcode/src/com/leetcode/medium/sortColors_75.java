package com.leetcode.medium;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，
 * 原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 */ //荷兰国旗问题
public class sortColors_75 {
    //三指针
    public void sortColors(int[] nums) {
        if (nums.length <= 1) return;
        int i = 0, j = 0, k = nums.length - 1;
        //i指针指向0的最后1个，j指针为移动指针，k指向末尾2的第一个
        while (j <= k) {
            if (nums[j] == 2) { //遇到2 往后放
                int temp = nums[k];
                nums[k] = nums[j];
                nums[j] = temp;
                k--;
            } else if (nums[j] == 1) { //遇到1  继续遍历
                j++;
            } else { //遇到0 往前放
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j++;
            }
        }
    }
}
