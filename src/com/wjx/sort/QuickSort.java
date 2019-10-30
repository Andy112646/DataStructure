package com.wjx.sort;

import java.util.Arrays;

/**
 * @Auther:wjx
 * @Date:2019/4/27
 * @Description:com.wjx.sort 快排
 * @version:1.0
 */
public class QuickSort {
    /**
     * 分区并调整基准数的位置
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private static int partition(int[] arr, int low, int high) {
        int i = low;
        int j = high;
        // 指定第一个元素是基准值
        int x = arr[low];

        while(i<j){
            // 右至左找到一个小于基准数的元素
            while (i<j && arr[j]>=x){
                j--;
            }
            // 找到了，将该元素移到左边
            if(i<j){
                arr[i] = arr[j];
                i++;
            }

            // 从左至右找到一个大于或等于基准数的元素
            while(i<j && arr[i]<x){
                i++;
            }
            if (i<j){
                arr[j]=arr[i];
                j--;
            }
        }
        // while执行完后i=j，此时填入基准值并返回index
        arr[i]=x;
        return i;
    }

    private static void quickSort(int[] arr, int low, int high) {
        // 递归终止条件
        if(low<high){
            // 进行分区，左边小，右边大，中间存基准数，返回基准数的index
            int n = partition(arr, low, high);
            // 对左边进行快排(递归)
            quickSort(arr, low, n-1);
            // 对右边进行快排(递归)
            quickSort(arr, n+1, high);
        }

    }

    public static void quickSort(int[] arr) {
        int low = 0;
        int high = arr.length-1;
        quickSort(arr, low, high);
    }

    public static void main(String[] args) {
        // 生成一个随机数组
        int[] arr = new int[10];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        // 输出该随机数组
        System.out.println(Arrays.toString(arr));

        // 快速排序
        quickSort(arr);

        // 输出快排后的数组
        System.out.println(Arrays.toString(arr));
    }

}
