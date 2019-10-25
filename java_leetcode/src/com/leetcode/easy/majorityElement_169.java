package com.leetcode.easy;

public class majorityElement_169 {
    public int majorityElement(int[] nums) {
        if (nums.length == 0) return 0;
        //遍历数组 如果遇到2个不同的数字 则去掉这2个的计数
        int count = 0, temp = 0;
//        int i = 0;
//        while (i < nums.length) {
//            if (count == 0) {
//                temp = nums[i];
//            }
//            if (temp == nums[i]) {
//                count++;
//                i++;
//            } else {
//                //count = count == 0 ? 0 : --count;
//                count--;
//                i++;
//            }
//        }

        for(int i =0;i<nums.length;i++){
            if(count==0){
                temp = nums[i];
            }
            if(temp==nums[i]){
                count++;
            }else {
                count--;
            }
        }

        return temp;
    }
}
