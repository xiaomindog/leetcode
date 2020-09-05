package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 示例:
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class permuteUnique_47 {

    //由于java列表查找是否重复效率较低，可以考虑先对数组排序来进行优化
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        if (nums.length == 0) return ans;
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs(nums, 0, visited, ans, new LinkedList<>());
        return ans;
    }

    //参数idx表示递归的深度 visited[]表示i索引元素是否被访问
    public void dfs(int[] nums, int idx, boolean[] visited, List<List<Integer>> ans, List<Integer> list) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (idx >= nums.length) return;

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            //这边判断条件!visited[i - 1]和visited[i - 1] 都是正确的 思考一下
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            dfs(nums, idx + 1, visited, ans, list);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }


    public List<List<Integer>> permuteUnique_1(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        if (nums.length == 0) return ans;
        boolean[] visited = new boolean[nums.length];
        dfs_1(nums, 0, visited, ans, new LinkedList<>());
        return ans;
    }

    //参数idx表示递归的深度 visited[]表示i索引元素是否被访问
    public void dfs_1(int[] nums, int idx, boolean[] visited, List<List<Integer>> ans, List<Integer> list) {
        if (list.size() == nums.length) {
            List<Integer> t = new ArrayList<>(list);
            if (!ans.contains(t)) {
                ans.add(t);
            }
            return;
        }
        if (idx >= nums.length) return;
        //循环的意义：
        //在非叶子结点处，产生不同的分支，在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            list.add(nums[i]);
            dfs_1(nums, idx + 1, visited, ans, list);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
