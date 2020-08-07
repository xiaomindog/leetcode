package com.leetcode.medium;


import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，
 * 其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 * 注意：
 * 总人数少于1100人。
 * 示例
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * <p>
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class reconstructQueue_406 {

    /**
     * 解题思路：先排序再插入
     * 1.排序规则：按照H降序，K升序排序
     * 2.遍历排序后的数组，根据K插入到K的位置上
     * 核心思想：高个子先站好位，矮个子插入到K位置上，
     * 前面肯定有K个高个子，矮个子再插到前面也满足K的要求
     */
    public int[][] reconstructQueue(int[][] people) {
        if (people.length == 0) return new int[0][];
        List<int[]> list = new LinkedList<>();
        /*Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[0] == t2[0] ? t1[1] - t2[1] : t2[0] - t1[0];
            }
        });*/
        Arrays.sort(people, (t1, t2) -> t1[0] == t2[0] ? t1[1] - t2[1] : t2[0] - t1[0]);
        for (int i = 0; i < people.length; i++) {
            list.add(people[i][1], people[i]); //按照K的位置来插入
        }
        return list.toArray(new int[list.size()][2]);
    }
}
