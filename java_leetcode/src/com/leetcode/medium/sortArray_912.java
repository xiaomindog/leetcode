package com.leetcode.medium;

/**
 * 给你一个整数数组nums，请你将该数组升序排列。
 * 示例 1：
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 * 提示：
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 */
public class sortArray_912 {
    //快速排序
    public int[] sortArray_1(int[] nums) {
        qSort(nums, 0, nums.length - 1);
        return nums;
    }

    public int partition(int[] nums, int i, int j) {
        int pivot = nums[i];
        while (i < j) {
            while (i < j && nums[j] >= pivot) j--;
            nums[i] = nums[j];
            while (i < j && nums[i] <= pivot) i++;
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        return i;
    }

    void qSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int p = partition(nums, left, right);
        qSort(nums, left, p - 1);
        qSort(nums, p + 1, right);
    }

    //选择排序 每一轮选择最小的
    public int[] sortArray_2(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            int temp = nums[min];
            nums[min] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }

    //冒泡
    public int[] sortArray_3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
        return nums;
    }

    //归并
    public int[] sortArray_4(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        return nums;
    }

    void mergeSort(int[] nums, int left, int right, int[] temp) {  // 需要左右边界确定排序范围
        if (left >= right) return;
        int mid = (left + right) / 2;
        // 先对左右子数组进行排序
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);

        //把当前数组拷贝到临时数组去
        for (int m = left; m <= right; m++) {
            temp[m] = nums[m];
        }

        int i = left, j = mid + 1;
        int cur = i;
        while (i <= mid && j <= right) {  // 开始合并数组
            if (temp[i] <= temp[j]) nums[cur] = temp[i++];
            else nums[cur] = temp[j++];
            cur++;
        }
        while (i <= mid) nums[cur++] = temp[i++];
        while (j <= right) nums[cur++] = temp[j++];
    }

}
