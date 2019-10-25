package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
/*给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
找到所有在 [1, n] 范围之间没有出现在数组中的数字。
您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。*/

public class findDisappearedNumbers_448 {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> notAppearing = new ArrayList<>();
        int n = nums.length;

        //每一轮都可以把一个数字放到自己的位置上去 最后比较一下索引和其值的差是否为1
        int j = 0;
        int temp;
        int count = 0;//退出循环的计数器
        while (j < n) {
            while ((nums[j] - j) != 1 &&
                    ((nums[nums[j] - 1] - (nums[j] - 1)) != 1)) { //当元素不在她应该在的位置 需要做交换
                temp = nums[j];
                nums[j] = nums[temp - 1];
                nums[temp - 1] = temp;
                count++;
            }
            j++;
        }
        for (int i = 0; i < n; i++) {
            if ((nums[i] - i) != 1) {
                notAppearing.add(i + 1);
            }
        }
        return notAppearing;
    }

    // 参考的题解的方法 应该是最优解了
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> notAppearing = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {

            nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
            //依次把数组里的元素作为索引的值，然后把该索引对应的值取负
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                notAppearing.add(i+1);
        }
        return notAppearing;
    }

    public static void main(String[] args) {
        int[] t = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> l = new ArrayList<>();
        l = findDisappearedNumbers2(t);
        System.out.println(l);
    }
}
