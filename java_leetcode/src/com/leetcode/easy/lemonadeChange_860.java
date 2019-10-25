package com.leetcode.easy;

public class lemonadeChange_860 {
    public boolean lemonadeChange(int[] bills) {
        if (bills.length <= 0) return true;
        int[] flag = new int[4];
        flag[0]=1; //第一张必须得是5元
        for(int i=1;i<bills.length;i++){
            if(bills[i]>(i+1)*5) return false;
            int t = bills[i];
            for(int j=3;j>=0;j--){
                if(flag[j]!=0&&t-(flag[j]+1)*5>=5){
                    t-=(flag[j]+1)*5;
                    flag[j]--;
                }
            }
            flag[bills[i]/5-1] +=1;
        }
        return false;
    }

}
