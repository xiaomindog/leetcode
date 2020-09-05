package com.Backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class combinationSum3_216 {
    static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> combinationSum3(int k, int n) {
        if (k <= 0) return ans;
        dfs(1, n, k, new ArrayList<>());
        return ans;
    }

    public static void dfs(int idx, int target, int k, List<Integer> list) {
        if (target < 0) return;
        if (target == 0 && list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        //因为当最后一个数正好取到的时候 如果放前面将会报错
        if (idx > 9) return;

        for (int i = idx; i <= 9; i++) {
            if (target - i < 0) break;
            list.add(i);
            dfs(i + 1, target - i, k, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 9));
    }

}
