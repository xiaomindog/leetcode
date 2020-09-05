package com.Backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [[7],
 * [2,2,3]]
 * 示例 2：
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [[2,2,2,2],
 *   [2,3,3],
 *   [3,5]]
 * <p>
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 */
public class combinationSum_39 {
    static List<List<Integer>> ans;

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new LinkedList<>();
        if (candidates.length == 0 || target < 0) return ans;
        dfs(candidates, target, 0, new LinkedList<>());
        return ans;
    }

    public static void dfs(int[] candidates, int target, int idx, List<Integer> list) {
        if (target < 0) return;
        if (target == 0) {
            ans.add(new LinkedList<>(list)); //重新深拷贝一个list,否则返回的都是[]
            return;
        }
        //因为每个数字都可以使用无数次，所以递归还可以从当前元素开始
        for (int m = idx; m < candidates.length; m++) {
            list.add(candidates[m]);
            dfs(candidates, target - candidates[m], m, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] cat = new int[]{2, 3, 6, 7};
        System.out.println(combinationSum(cat, 7));
    }
}
