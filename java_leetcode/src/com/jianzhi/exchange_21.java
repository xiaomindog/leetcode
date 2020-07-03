package com.jianzhi;

public class exchange_21 {
    public static int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {

            while (nums[i] % 2 == 1 && i < j) {
                i++;
            }

            while (nums[j] % 2 == 0 && j > i) {
                j--;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        return nums;
    }

    public static int[] exchange_2(int[] nums) {
        int fast = 0, low = 0;
        while (fast < nums.length) {
            if (nums[fast] % 2 == 1) {
                int t = nums[fast];
                nums[fast] = nums[low];
                nums[low] = t;
                low++;
            }
            fast++;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] a = {2, 16,};
        int[] nums = exchange_2(a);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
