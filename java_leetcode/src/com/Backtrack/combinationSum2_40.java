package com.Backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*** 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *candidates 中的每个数字在每个组合中只能使用一次。
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合*/
public class combinationSum2_40 {
    static List<List<Integer>> ans;

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new LinkedList<>();
        if (candidates.length == 0 || target < 0) return ans;
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new LinkedList<>());
        return ans;
    }

    public static void dfs(int[] candidates, int target, int idx, List<Integer> list) {
        if (target < 0) return;
        if (target == 0) {
            ans.add(new LinkedList<>(list));
            return;
        }

        for (int m = idx; m < candidates.length; m++) {
//            if (target - candidates[m] < 0) {
//                break;
//            }
            if (m > idx && candidates[m] == candidates[m - 1]) continue;
            list.add(candidates[m]);
            dfs(candidates, target - candidates[m], m + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] cat = new int[]{10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum2(cat, 8));
    }
}
