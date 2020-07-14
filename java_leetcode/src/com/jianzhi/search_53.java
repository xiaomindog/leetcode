package com.jianzhi;

//统计一个数字在排序数组中出现的次数。
public class search_53 {

    /*若 nums[m] < target ，则 target 在闭区间[m+1,j] 中，
    因此执行i=m+1；
    若 nums[m] > target，则 target在闭区间[i,m−1] 中，
    因此执行j=m−1；
    若 nums[m] = target，
    则右边界right在闭区间[m+1,j] 中；
    左边界left在闭区间[i,m−1] 中*/
    public static int search(int[] nums, int target) {
        if (nums.length <= 0) return 0;

        //1.确定右边界
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            if (nums[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        int right = i;
        //2.确定左边界
        i = 0;
        //j = nums.length - 1; //这一步可以优化，j的位置在右边界的前1个
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        int left = j;
        return right - left - 1;
    }


    public static void main(String[] args) {
        int ans[] = new int[]{1, 2, 2, 3, 4, 5, 6, 7, 8, 7, 4, 5, 5, 6, 7};
        int count = search(ans, 2);
        System.out.println(count);
    }
}
