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
        if (left >= right) return; //一方面作为递归出口，一方面排除特殊情况
        //-------------------确认分界点----------------------------------
        int i = left - 1, j = right + 1, x = array[(left + right) >> 1];
        //-------------------partition---------------------------------
        while (i < j) {
            do i++; while (array[i] < x);
            do j--; while (array[j] > x);
            //分区过程之后，认为i的左边都是小于x的，j右边都是大于x的
            if (i < j) { // 保证是在正常当情况再交换
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        //-------------------递归部分-----------------------------------
        //此时i，j相等
        //因为选择分界点的时候，是在偶数的时候是偏左的，当left=0；right=1的时候为0，这是i-1就是负数，就会出现问题
        quick_sort(array, left, j);
        quick_sort(array, j + 1, right);
    }
}
