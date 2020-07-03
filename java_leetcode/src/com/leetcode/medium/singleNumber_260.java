package com.leetcode.medium;

/*给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。
 找出只出现一次的那两个元素。*/

public class singleNumber_260 {
    public int[] singleNumber(int[] nums) {
        if (nums.length <= 1) return new int[]{};
        int all_bit = 0;
        //先算出所有值的异或的结果
        for (int i = 0; i < nums.length; i++) {
            all_bit ^= nums[i];
        }
        // 计算异或结果第一个为1的位置
        int flag = 0; //需要的移位次数
        while ((all_bit & 1) == 0) {
            flag++;
            all_bit >>= 1;
        }
        int split1 = 0, split2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] >> flag & 1) == 1) {
                split1 ^= nums[i];
            } else {
                split2 ^= nums[i];
            }
        }
        return new int[]{split1, split2};
    }

}
