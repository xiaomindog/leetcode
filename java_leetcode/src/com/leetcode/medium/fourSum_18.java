package com.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//8. 四数之和
public class fourSum_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        if (nums.length <= 3) return ans;
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 4; i++) {
            for (int j = i + 1; j <= nums.length - 3; j++) {
                int m = j + 1, n = nums.length - 1;
                while (m < n) {
                    int sum = nums[i] + nums[j] + nums[m] + nums[n];
                    if (sum > target) {
                        n--;
                    } else if (sum < target) {
                        m++;
                    } else {
                        List<Integer> list = new LinkedList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[m]);
                        list.add(nums[n]);
                        if (!ans.contains(list)) {
                            ans.add(list);
                        }
                        m++;
                        n--;
                    }
                }
            }
        }
        return ans;
    }
}
