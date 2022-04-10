package com.ls.sortAndSearch;

import java.util.Arrays;

public class A合并两个有序数组 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
//        int[] nums1 = {0};
//        int m = 0;
//        int[] nums2 = {1};
//        int n = 1;
        merge3(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }

    // 归并排序
    public static void merge(int[] nums1,int m,int[] nums2, int n){
        int[] temp = new int[m+n];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < m && j < n){
            if(nums1[i] <= nums2[j])
                temp[index++] = nums1[i++];
            else
                temp[index++] = nums2[j++];
        }
        for (;i<m;){
            temp[index++] = nums1[i++];
        }
        for(;j<n;){
            temp[index++] = nums2[j++];
        }
        // 把数组temp中的值赋给nums1
        if (m + n >= 0) System.arraycopy(temp, 0, nums1, 0, m + n);
    }


    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
//        for (int i = m,j = 0; i < nums1.length; i++) {
//            nums1[i] = nums2[j++];
//        }
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
    }

    public static void merge3(int[] nums1,int m,int[] nums2,int n){
        int i = m-1;
        int j = n-1;
        int end = m+n-1;
        while (j>=0){
            nums1[end--] = (i >= 0 && nums1[i] > nums2[j] ? nums1[i--] : nums2[j--]);
        }
    }


}
