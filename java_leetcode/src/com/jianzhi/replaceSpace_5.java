package com.jianzhi;
/*
*请实现一个函数，将一个字符串中的每个空格替换成“%20”。
* 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。*/

public class replaceSpace_5 {
    public static String replaceSpace(StringBuffer str) {
        int n = 0;
        //先找到空格的个数
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                n++;
            }
        }
        int len = str.length();
        str.setLength(len+2*n); //修改string的长度
        int p = str.length()-1;
        for(int i=len-1;i>=0;i--){
            if (str.charAt(i)!=' '){
                str.setCharAt(p--,str.charAt(i));

            }else {
                str.setCharAt(p--,'0');
                str.setCharAt(p--,'2');
                str.setCharAt(p--,'%');
            }
        }
        return str.toString();
    }





    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("we are friend");

        String s = replaceSpace(str);
        System.out.println(s.charAt(2));
    }
}
