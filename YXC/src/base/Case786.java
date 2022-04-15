package base;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @ClassName Case786
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/15 20:56
 * @Version v0.1
 **/
public class Case786 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        k = k-1;
        int i = quickSort(array, k, 0, array.length-1);
        System.out.println(i);
    }
    public static int quickSort(int[] array,int k,int left,int right){
        if (left==right){
            return array[left];
        }
        int mid = array[left+right+1>>1];
        int i = left-1;
        int j = right+1;
        while(i<j){
            do i++;while(array[i]<mid);
            do j--;while(array[j]>mid);
            if (i<j){
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        if (k<=j){
            return quickSort(array,k,left,j);
        }else{
            return quickSort(array,k,j+1,right);
        }

    }
}
