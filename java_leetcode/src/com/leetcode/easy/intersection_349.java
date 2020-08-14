package com.leetcode.easy;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//两个数组的交集
public class intersection_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new LinkedList<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i) && !list.contains(i)) {
                list.add(i);
            }
        }
        int res[] = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
