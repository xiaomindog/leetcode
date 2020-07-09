package com.jianzhi;


//数组中超过1半的数字
//[1, 2, 3, 2, 2, 2, 5, 4, 2] -->2
public class majorityElement_39 {
    public int majorityElement(int[] nums) {
        if (nums.length <= 0) return 0;
        //遍历数组 用一个计数器记录个数 遇到2个不同的数 count--
        int count = 0, temp = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) temp = nums[i];
            if (temp == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return temp;
    }
}
