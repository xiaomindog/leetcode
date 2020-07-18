package com.jianzhi;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。
 * A 不能视为 14。
 */

public class isStraight_61 {

    //1.除0外，无重复牌
    //2.考虑非0元素，最大-最小<=4 必定是顺子
    public boolean isStraight(int[] nums) {
        if (nums.length != 5) return false;
        Arrays.sort(nums); //
        int count_0 = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) count_0++;  //0的个数
            else if (nums[i] == nums[i + 1]) return false; //有重复数
        }
        int ma = nums[4], mi = nums[count_0];
        return ma - mi < 5;
    }
}
