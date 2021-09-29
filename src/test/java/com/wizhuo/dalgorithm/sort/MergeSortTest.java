package com.wizhuo.dalgorithm.sort;

import com.sun.tools.javac.util.Assert;
import org.junit.Test;

import java.util.Random;

/**
 * @author willJo
 * @since 2021/9/29
 */
public class MergeSortTest {

    @Test
    public void sortTest() {

        Random random = new Random();
        int n = 100;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = random.nextInt(100);
        }
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                Assert.check(a[i - 1] <= a[i]);
            }
        }
    }

}