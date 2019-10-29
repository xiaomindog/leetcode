package com.leetcode.medium;

/*给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
注意：答案中不可以包含重复的三元组。

最暴力的肯定是O(n3) 不可取
可否借助twoSum的思想
参考谈论区 先排序 再3指针可行转化为两数之和
*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum_15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) return ans;
        Arrays.sort(nums);


        //确定第一个数 然后双指针分别指向剩下中的头尾 相向而行
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break; //第一个数为正数
            if (i > 0 && nums[i] == nums[i - 1]) continue; //后面的数如果和前面相同则继续下一个遍历

            int m = i + 1, n = nums.length - 1;
            while (m < n) {
                if (n < nums.length - 1 && nums[n] == nums[n + 1] || nums[i] + nums[m] + nums[n] > 0) {
                    n--;
                } else if (m > i + 1 && nums[m] == nums[m - 1] || nums[i] + nums[m] + nums[n] < 0) {
                    m++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[m]);
                    list.add(nums[n]);
                    ans.add(list);
                    m++;
                    n--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-2,-1,-1,0,1,1,2};
        System.out.println(threeSum(nums));
    }
}
