package com.leetcode.medium;

import java.util.*;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class permute_44 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        if (nums.length == 0) return ans;
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
        //循环的意义：
        //在非叶子结点处，产生不同的分支，在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            list.add(nums[i]);
            dfs(nums, idx + 1, visited, ans, list);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }

    List<List<Integer>> ans;
    //每次两两交换的方法
    public List<List<Integer>> permute_1(int[] nums) {
        ans = new LinkedList<>();
        if (nums.length == 0) return ans;
        Integer[] n = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            n[i] = nums[i];
        }
        dfs_1(n, 0);
        return ans;
    }


    public void dfs_1(Integer[] n, int idx) {
        if (idx == n.length - 1) {
            ans.add(Arrays.asList(n.clone()));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = idx; i < n.length; i++) {
            if (set.contains(n[i])) continue;
            set.add(n[i]);
            swap(n, i, idx);
            dfs_1(n, idx + 1);//固定idx索引的元素
            swap(n, i, idx);

        }
    }

    public void swap(Integer[] n, int a, int b) {
        Integer temp = n[a];
        n[a] = n[b];
        n[b] = temp;
    }
}
