package com.jianzhi;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//数组中最小的K个数
public class getLeastNumbers_40 {

    //最大堆  其中java自带最小堆 需要重写比较大小容器
    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) return new int[0];
        Queue<Integer> heap = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                heap.offer(arr[i]);
            } else if (arr[i] < heap.peek()) { //堆顶元素大于遍历元素，删除堆顶元素，遍历元素加入堆
                heap.poll();
                heap.offer(arr[i]);
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll();
        }
        return ans;
    }

    //利用小顶堆的性质 //默认是小顶堆 把原数组的所有数取反
    //时间复杂度 O(nlogk) 空间复杂度O(k)
    public static int[] getLeastNumbers_1(int[] arr, int k) {
        if (k == 0) return new int[0];
        Queue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                heap.offer(-arr[i]);
            } else if (-arr[i] > heap.peek()) { //堆顶元素小于遍历元素，删除堆顶元素，遍历元素加入堆
                heap.poll();
                heap.offer(-arr[i]);
            } else
                continue;
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = -heap.poll();
        }
        return ans;
    }

    //快速排序的思想 时间复杂度O(n) 空间复杂度O(logn)
    public int[] getLeastNumbers_2(int[] arr, int k) {
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

    public static void main(String[] args) {
        int a[] = new int[]{0, 0, 0, 2, 0, 5};
        int out[] = getLeastNumbers(a, 0);
    }
}
