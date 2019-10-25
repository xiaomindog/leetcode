package com.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class singleNumber_136 {

    //位运算  o(n) o(1)
    public int singleNumber(int[] nums) {
        int single=0;
        for(int i =0;i<nums.length;i++){
            single = single^nums[i];
        }
        return single;
    }



    //数学小技巧  2∗(a+b+c)−(a+a+b+b+c)=c  o(n) o(n)
    public static int singleNumber2(int[] nums) {
        Set hs = new HashSet<>();
        int sum = 0;
        int s = 0;
        for(int i=0;i<nums.length;i++){
            if(hs.add(nums[i])){
                s+=nums[i];
            }
            sum+=nums[i];
        }
        return 2*s-sum;
    }

    public static void main(String[] args) {
        int [] nums = {5,2,2,5,3,4,4};
        System.out.println(singleNumber2(nums));
    }
}
