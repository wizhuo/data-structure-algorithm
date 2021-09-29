package com.wizhuo.dalgorithm.sort;

import java.util.Random;

/**
 * 归并算法
 * <p>
 * 时间复杂度 O(nlogn)
 * 每一个小sort 的时间复杂度O(logn)
 * merge 的时间复杂度O(n)
 * 相乘 O(nlogn)
 * <p>
 * 空间复杂度是O(n) merge 的时候
 *
 * @author willJo
 * @since 2021/9/29
 */
public class MergeSort {

    public static void main(String[] args) {

        Random random = new Random();
        int n = 100;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = random.nextInt(100);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]);
            System.out.print(" ");
        }

        System.out.println("");

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]);
            System.out.print(" ");

        }
    }


    /**
     * 两个数组合并为一个数组
     * low-mid 假设为a 数组
     * mid+1 为b 数组
     * 改地方为两个数组合并为一个数组，这样应该比较好理解一点
     *
     * @param a
     * @param low  数组的最小值 （包含）
     * @param mid  数组的中间值
     * @param high 数组的高位 （包含）
     */
    public void merge(int[] a, int low, int mid, int high) {


        int length = (high - low + 1);
        int[] aux = new int[length];

        int i = low;
        int j = mid + 1;


        for (int k = 0; k < length; k++) {
            if (i > mid) {
                // 如果a 数据已经用完了，直接赋值b 数组
                aux[k] = a[j++];
            } else if (j > high) {
                // 如果b 数组已经用完了，直接用a 数组
                aux[k] = a[i++];
            } else if (less(a, i, j)) {
                // 两个数组取值最小的那个
                aux[k] = a[i++];
            } else {
                // 两个数组取值最小的那个
                aux[k] = a[j++];
            }
        }

        //把排好序的内容放回原来的数组
        int n = low;
        for (int m : aux) {
            a[n] = m;
            n++;
        }


    }

    public boolean less(int[] a, int i, int j) {
        return a[i] < a[j];
    }

    /**
     * 排序
     *
     * @param a
     * @param start
     * @param end
     */
    public void sort(int[] a, int start, int end) {

        // 递归算法一定先写好结束条件
        if (start >= end) {
            return;
        }


        int mid = (start + end) / 2;
        sort(a, start, mid);
        sort(a, mid + 1, end);
        merge(a, start, mid, end);


    }
}
