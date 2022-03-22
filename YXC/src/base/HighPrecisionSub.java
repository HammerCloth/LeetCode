package base;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName HighPrecisionSub
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/3/19 15:58
 * @Version v0.1
 **/
public class HighPrecisionSub {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        char[] charA = sc.nextLine().toCharArray();
        char[] charB = sc.nextLine().toCharArray();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for (int i = charA.length - 1; i >= 0; i--) a.add(charA[i] - '0');
        for (int i = charB.length - 1; i >= 0; i--) b.add(charB[i] - '0');
        //通过compare来判断a和b的大小，从而输出-号
        List<Integer> c = new ArrayList<>();
        if (compare(a, b)) {
            c = sub(a, b);
        } else {
            // a < b, a - b = -(b - a)
            c = sub(b, a);
            System.out.print('-');
        }
        //注意存储方式
        for (int i = c.size() - 1; i >= 0; i--) System.out.print(c.get(i));
    }


    /**
     * C = A - B, 满足A >= B, A >= 0, B >= 0
     *
     * @param a 存储大整数的容器，大整数低位存储在容器小端
     * @param b 存储大整数的容器，大整数低位存储在容器小端
     * @return 减法运算的结果
     */
    public static List<Integer> sub(List<Integer> a, List<Integer> b) {
        List<Integer> c = new ArrayList<>();
        int t = 0;
        for (int i = 0; i < a.size(); i++) {
            t = a.get(i) - t;
            if (i < b.size()) t -= b.get(i);
            c.add((t + 10) % 10);
            if (t < 0) t = 1;
            else t = 0;
        }
        while (c.size() > 1 && c.get(c.size() - 1) == 0) c.remove(c.size() - 1);
        return c;
    }

    /**
     * 先判断是否相等，在做出决断，值得学习
     *
     * @param a 存储大整数的容器，大整数低位存储在容器小端
     * @param b 存储大整数的容器，大整数低位存储在容器小端
     * @return a>=b 的结果
     */
    public static boolean compare(List<Integer> a, List<Integer> b) {
        if (a.size() != b.size()) return a.size() > b.size();
        for (int i = a.size() - 1; i >= 0; i--) {
            if (a.get(i) != b.get(i)) return a.get(i) > b.get(i);
        }
        return true;
    }
}
