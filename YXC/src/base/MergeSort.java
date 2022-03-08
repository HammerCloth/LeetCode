package base;

import java.util.Arrays;

/**
 * @ClassName MergeSort
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/3/8 9:32 AM
 * @Version v0.1
 **/
public class MergeSort {

    public static void main(String[] args) {

    }

    /**
     * @param temp  辅助数组，为了提升效率，所以将辅助数组在上下文申明好，直接在函数中调用
     * @param array 待排序数组
     * @param left  待排序数组最左下标
     * @param right 带排序数组最右下标
     */
    public static void merge_sort(int[] temp, int[] array, int left, int right) {
        //-----------------------特殊情况排除，以及递归出口-------------------------
        if (left >= right) return;
        //------------------------递归排序---------------------------------------
        int mid = (left + right) >> 1;
        merge_sort(temp, array, left, mid);
        merge_sort(temp, array, mid + 1, right);
        //------------------------归并两个已经排序的数组---------------------------
        int k = 0;
        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {//第一阶段将小的放到temp中
            if (array[i] <= array[j]) { //优先左边的队列，保证稳定
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        while (i <= mid) temp[k++] = array[i++];//将没有循环的尾巴插入队列中
        while (j <= right) temp[k++] = array[j++];

        for (i = left, j = 0; i <= right; i++, j++) {
            array[i] = temp[j];//将排序好的数组，放入array的原位置
        }

    }
}
