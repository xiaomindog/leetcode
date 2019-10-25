package com.leetcode.easy;

public class hammingDistance_461 {
    public static int hammingDistance(int x, int y) {
        String xb = Integer.toBinaryString(x);
        String yb = Integer.toBinaryString(y);
        int i = xb.length() - 1;
        int j = yb.length() - 1;
        int count = 0;
        while (i >= 0 && j >= 0) {
            if (xb.charAt(i) != (yb.charAt(j))) {
                count++;
            }
            i--;
            j--;
        }

        while (i >= 0) {
            if (xb.charAt(i) == '1') {
                count++;
            }
            i--;
        }
        while (j >= 0) {
            if (yb.charAt(j) == '1') {
                count++;
            }
            j--;
        }
        return count;
    }


    public static int hammingDistance2(int x, int y) {
        int count = 0;
        while (x != 0 || y != 0) {
            if ((x & 1) != (y & 1)) { //x&1 取二进制最小位
                count++;
            }
            x>>=1;
            y>>=1;
        }

        return count;
    }

    public static void main(String[] args) {
        int t = hammingDistance(1, 4);
        System.out.println(t);
        System.out.println(5 >> 1);
    }
}
