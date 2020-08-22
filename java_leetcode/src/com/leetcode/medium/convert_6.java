package com.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Z字型变化
public class convert_6 {
    public String convert_1(String s, int numRows) {
        if (numRows <= 1) return s;
        char[] str = s.toCharArray();
        List<StringBuffer> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuffer());
        }
        int flag = -1, i = 0;
        for (char c : str) {
            list.get(i).append(c);
            if (i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }
        StringBuffer res = new StringBuffer();
        for (StringBuffer ss : list) {
            res.append(ss);
        }
        return res.toString();
    }

    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        StringBuffer str = new StringBuffer();
        int column = 2 * numRows - 2;
        //第一行
        int k = 0;
        while (k * column < s.length()) {
            str.append(s.charAt(k * column));
            k++;
        }

        //中间的行
        for (int i = 1; i < numRows - 1; i++) {
            k = 0;
            while (k * column + i < s.length() || (k + 1) * column - i < s.length()) {
                if (k * column + i < s.length()) {
                    str.append(s.charAt(k * column + i));
                }
                if ((k + 1) * column - i < s.length()) {
                    str.append(s.charAt((k + 1) * column - i));
                }
                k++;
            }
        }

        //最后一行的数据
        k = 0;
        while (k * column + numRows - 1 < s.length()) {
            str.append(s.charAt(k * column + numRows - 1));
            k++;
        }

        return str.toString();
    }

}
