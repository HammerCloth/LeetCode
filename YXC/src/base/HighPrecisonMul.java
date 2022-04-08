package base;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName HighPrecisonMul
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/3/30 10:11
 * @Version v0.1
 **/
public class HighPrecisonMul {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        char[] A = sc.nextLine().toCharArray();
        List<Integer> a = new ArrayList<>();
        for (int i = A.length - 1; i >= 0; i--) a.add(A[i] - '0');
        int b = sc.nextInt();
        List<Integer> mul = mul(a, b);
        for (int i = mul.size() - 1; i >= 0; i--) System.out.print(mul.get(i));
    }

    /**
     * 大整数乘法
     * @param a 大整数a
     * @param b 小整数b
     * @return 存储积的集合
     */
    public static List<Integer> mul(List<Integer> a, int b) {
        List<Integer> c = new ArrayList<>();
        //保存当前的溢出数值
        int t = 0;
        //这里通过在条件上或t不为0，可以将a已经乘完并且t还存在溢出的部分继续处理，很精妙
        for (int i = 0; i < a.size() || t != 0; i++) {
            if (i < a.size()) t += a.get(i) * b; //将a逐位来进行运算，超过a的位数就只需要处理溢出的数值
            c.add(t % 10);
            t /= 10;
        }
        while (c.size() > 1 && c.get(c.size() - 1) == 0) c.remove(c.size() - 1);
        return c;
    }
}
