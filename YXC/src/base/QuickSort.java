package base;

import java.io.BufferedInputStream;
import java.util.Arrays;

/**
 * @ClassName QuickSort
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/3/7 9:29 AM
 * @Version v0.1
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{4, 3, 2, 1};
        System.out.println(Arrays.toString(array));
        quick_sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    /**
     *
     * @param array 需要进行快速排序的数组
     * @param left 数组下标的左边界
     * @param right 数组下标的右边界
     */
    public static void quick_sort(int[] array, int left, int right) {
        if (left >= right) return;
        int i = left - 1, j = right + 1, x = array[(left + right) >> 1];
        while (i < j) {
            do i++; while (array[i] < x);
            do j--; while (array[j] > x);
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        quick_sort(array, left, j);
        quick_sort(array, j + 1, right);
    }
}
