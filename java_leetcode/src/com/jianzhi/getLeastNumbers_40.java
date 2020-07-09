package com.jianzhi;


//数组中最小的K个数
public class getLeastNumbers_40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        //快速排序模板
        quickSort(arr, 0, arr.length - 1, k);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    public void quickSort(int s[], int left, int right, int k) {
        if (k == 0) return;
        if (left < right) {
            int i = left, j = right, pivot = s[left];
            while (i < j) {
                while (i < j && s[j] >= pivot) j--;// 从右向左找第一个小于x的数
                if (i < j)
                    s[i++] = s[j];

                while (i < j && s[i] < pivot) i++;// 从左向右找第一个大于等于x的数
                if (i < j)
                    s[j--] = s[i];
            }
            s[i] = pivot;
            quickSort(s, left, i - 1, k - 1); // 递归调用
            quickSort(s, i + 1, right, k - 1);
        }
    }

}
