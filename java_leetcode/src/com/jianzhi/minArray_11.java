package com.jianzhi;

//旋转数组的最小数字
/*把一个数组最开始的若干个元素搬到数组的末尾，
我们称之为数组的旋转。
输入一个递增排序的数组的一个旋转，
输出旋转数组的最小元素。
例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，
该数组的最小值为1。  
*/
public class minArray_11 {
    public int minArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (i == numbers.length - 1) return numbers[0];

            if (numbers[i + 1] < numbers[i]) {
                return numbers[i + 1];
            }
        }

        return 0;
    }


    //二分法 最优解
    //排序数组的查找问题首先考虑使用 二分法 解决，
    // 其可将遍历法的 线性级别 时间复杂度降低至 对数级别

    //左排序数组任意元素大于等于右排序数组任意元素
    public int minArray02(int[] numbers) {
        if (numbers.length <= 0) return 0;

        int i = 0, j = numbers.length - 1;

        if (numbers[i] < numbers[j]) {
            return numbers[i];
            //如果左排序数组最小值小于右排序数组最大值
            // 旋转点就是第一个值
        }


        while (i < j) { //i==j时候跳出循环
            int mid = i + (j - i) / 2;

            if (numbers[mid] > numbers[j]) {
                i = mid + 1; // m一定在右半数组
            } else if (numbers[mid] < numbers[j]) {
                j = mid;
            } else {
                j = j - 1;
            }
        }
        return numbers[i];

    }
}



