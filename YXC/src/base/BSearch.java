package base;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @ClassName BSearch
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/3/11 4:57 PM
 * @Version v0.1
 **/
public class BSearch {


    public static boolean check_1(int x,int[] array,int k){
        if (array[x]<=k){
            return true;
        }else return false;
    }

    public static boolean check_2(int x,int[] array,int k){
        if (array[x]>=k){
            return true;
        }else return false;
    }

    /**
     * 二分法模型
     * @param left 二分的左边界
     * @param right 二分数组的右边界
     * @return 获得满足条件的边界，如果无法满足条件，会找到数组边界来返回
     */
    public static int bSearch_1(int left,int right) {
        while (left < right) {
            int mid = left + right >> 1;
            if (check(mid)) right = mid; //如果满足条件需要动right的话，则mid就不需要加1
            else left = mid + 1;
        }
        return left;
    }
     public static int bSearch_2(int left,int right){
        while(left<right){
            int mid = left + right + 1 >>1;
            if (check(mid)) left = mid;//如果满足条件需要动left，为了防止出现死循环，需要mid+1，向上取整数
            else right = mid -1;
        }
        return left;
    }
    public static boolean check(int mid){
        return true;
    }
    public static boolean check(double mid){
        return true;
    }

    /**
     * 浮点数二分
     * @param left 左边界，可以直接使用已知的范围来做
     * @param right 右边界，可以直接使用已知的范围来做
     * @return 返回结果可以调试一下，right或者left都可以的
     */
    public static double bSearch_3(double left,double right){
        double eps = 1e-6;//可以通过增大精度来获得更加精确的计算
        while(right-left>eps){
            double mid = (right+left)/2;
            if (check(mid)) right = mid;
            else left = mid;
        }
        return left;//left或者right根据调试来看
    }
}
