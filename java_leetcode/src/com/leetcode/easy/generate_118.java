package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class generate_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> A = new ArrayList<>();
        if(numRows<=0)
            return A;
        for(int i =0;i<numRows;i++){ //第一列都是1和每行最后一个都是1
            List<Integer> t = new ArrayList<>();
            t.add(1);
            if(i>0)
                t.add(1);
            A.add(t);
        }
        for(int i=2;i<numRows;i++){  // i是行数
            for(int j=1;j<i;j++){  //j是列数
                A.get(i).add(j,A.get(i-1).get(j)+A.get(i-1).get(j-1));
            }

        }

        return A;
    }

    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> A = new ArrayList<>();
        if(numRows<=0)
            return A;
        A.get(0).add(1); //第一行第一个元素为1
        for(int i=1;i<numRows;i++){
            List<Integer> B = new ArrayList<>();
            B.add(1);
            for(int j = 1;j<i;j++){
                B.add(A.get(i-1).get(j)+A.get(i-1).get(j-1));
            }
            B.add(1);
            A.add(B);
        }
        return A;
    }
}
