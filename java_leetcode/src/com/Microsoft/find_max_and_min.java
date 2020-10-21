package com.Microsoft;

//寻找数组中的最大值和最小值
public class find_max_and_min {

    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    public static int[] find(int[] nums) {
        if (nums.length == 0) return new int[2];
        if (nums.length == 1) return new int[]{nums[0], nums[0]};
        int []ans = merge(nums, 0, nums.length - 1);
        return ans;
    }

    public static int[] merge(int[] arr, int i, int j) {
        if (j - i <= 1) {
            if (arr[i] < arr[j]) {
                return new int[]{arr[i], arr[j]};
            } else {
                return new int[]{arr[j], arr[i]};
            }
        }
        int mid = (i + j) / 2;
        int[] left = merge(arr, i, mid);
        int[] right = merge(arr, mid + 1, j);
        if (left[0] > right[0]) {
            min = right[0];
        } else {
            min = left[0];
        }
        if (left[1] > right[1]) {
            max = left[1];
        } else {
            max =  right[1];
        }
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        int a[] = new int[]{4, 3, 6, 1, 8, 5, 2};
        //int a[] = new int[]{2, 1};

        int[] minmax = find(a);
        System.out.println(minmax[0] + "  " + minmax[1]);
    }
}
