package com.leetcode.easy;

import java.util.Arrays;

public class findContentChildren_455 {

    public int findContentChildren(int[] g, int[] s) {
        int count=0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0,j=0;
        while(i<g.length&&j<s.length){
            if(g[i]<=s[j]){
                count++;
                i++;j++;
            }else {
                j++;
            }
        }
        return count;
    }




    //超时方法 暴力
    public int findContentChildren2(int[] g, int[] s) {
        int count=0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0,j=0;
       while(i<g.length){
            while (j<s.length){
                if(g[i]>s[j])
                    j++;
                else {
                    count++;
                    i++;j++;
                }
            }
        }
        return count;
    }
}
