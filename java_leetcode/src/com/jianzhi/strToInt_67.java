package com.jianzhi;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.EventListener;
import java.util.List;

//把字符串转换成整数
public class strToInt_67 {
    public static int strToInt(String str) {
        int flag = 1; //正负号标记
        int i = 0;
        StringBuffer res = new StringBuffer();
        //1.删除首部空格
        while (i < str.length() && str.charAt(i) == ' ') i++;
        //2.判断正负号位
        if (i < str.length()) {
            if (str.charAt(i) == '-') {
                flag = -1;
                i++;
            } else if (str.charAt(i) == '+') {
                flag = 1;
                i++;
            }
            if (i < str.length() && (str.charAt(i) < '0' || str.charAt(i) > '9')) { //
                return 0;
            }
        }
        while (i < str.length()) {
            while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                res.append(str.charAt(i));
                i++;
            }
            if (res.length() > 0) break;
        }

        int border = Integer.MAX_VALUE / 10; //   2147483647/10
        if (res.length() == 0) return 0;
        int ans = 0;
        for (int j = 0; j < res.length(); j++) {
            ans = 10 * ans + res.charAt(j) - '0';

            if ((ans == border && j <= res.length() - 2 && res.charAt(j + 1) - '0' > 7) ||
                    (ans > border && j <= res.length() - 2)) {
                if (flag == 1) {
                    return Integer.MAX_VALUE;//如：2147483648
                } else {
                    return Integer.MIN_VALUE;
                }
            }
        }
        return ans * flag;
    }

    public static void main(String[] args) {
        String str = "2147483648";
        int a = strToInt(str);
        System.out.println(a);

    }
}
