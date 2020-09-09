package com.Backtrack;

import java.util.*;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
public class subsetsWithDup_90 {


    //这个思路同combination_38_ 字符串的组合问题  当前选或不选 2种状态转移
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        dfs(0, nums, res, ans);
        return res;
    }

    public static void dfs(int i, int[] nums, List<List<Integer>> res, List<Integer> ans) {
        if (i == nums.length) {
            res.add(new ArrayList<>(ans));
            return;
        }
        // 如果不选当前的，直接跳到不重复的地方
        // 这里是难点 要想通  为什么当前这个不选 就要跳过呢？
        //要么都不出现 要么依次出现
        int count = 0;
        for (int j = i; j < nums.length; j++) {
            if (nums[i] == nums[j]) {
                count++;
            } else break;
        }
        dfs(i + count, nums, res, ans);//当前元素不选
        ans.add(nums[i]);
        dfs(i + 1, nums, res, ans); //选择当前元素
        ans.remove(ans.size() - 1);
    }

    //从leetcode上的数据来看效率比较低。
    //利用map统计每个数字出现的次数
    public static List<List<Integer>> subsetsWithDup_2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i : nums) {
            if (hash.containsKey(i)) {
                hash.put(i, hash.get(i) + 1);
            } else {
                hash.put(i, 1);
            }
        }
        System.out.println(hash);
        res.add(new ArrayList<>());
        for (int key : hash.keySet()) {
            int len = res.size();
            for (int i = 0; i < len; i++) {
                List<Integer> list = new ArrayList<>(res.get(i));

                System.out.println(list);
                for (int j = 1; j <= hash.get(key); j++) {
                    list.add(key);
                    res.add(new ArrayList<>(list));
                }
            }
        }
        return res;
    }

    //递归回溯
    static List<List<Integer>> ans;

    public static List<List<Integer>> subsetsWithDup_1(int[] nums) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            dfs(nums, 0, i, visited, new ArrayList<>());
        }
        return ans;
    }

    public static void dfs(int[] nums, int x, int k, boolean[] visited, List<Integer> list) {
        if (k == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (x >= nums.length) return;

        for (int i = x; i < nums.length; i++) {
            //分析 数组已经排序，相等的元素前后出现，当前面的数未访问才继续访问
            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            dfs(nums, i + 1, k - 1, visited, list);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(subsetsWithDup_2(new int[]{1, 2, 1, 2}));
    }
}
