package base;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName HighPrecision
 * @Description 高精度计算
 * @Author SiYiXiong
 * @Date 2022/3/19 00:19
 * @Version v0.1
 **/
public class HighPrecisionAdd {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        char[] strA = sc.nextLine().toCharArray();
        char[] strB = sc.nextLine().toCharArray();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for (int i = strA.length - 1; i >= 0; i--) a.add(strA[i] - '0'); //倒序放入数组中，数字的低位放入数组的最左端
        for (int i = strB.length - 1; i >= 0; i--) b.add(strB[i] - '0');
        //todo
        List<Integer> c = sub(a, b);
        for (int i = c.size() - 1; i >= 0; i--) {
            System.out.print(c.get(i));
        }
    }

    // C = A + B, A >= 0, B >= 0
    public static List<Integer> add(List<Integer> a, List<Integer> b) {
        if (a.size() < b.size()) return add(b, a); //保证a为位数最长的，防止后面出现空指针
        List<Integer> c = new ArrayList<>();
        int t = 0; //进位
        for (int i = 0; i < a.size(); i++) {
            t += a.get(i);
            if (i < b.size()) t += b.get(i); // t+a+b
            c.add(t % 10); //余数作为这一个位置上数字
            t /= 10; //商作为进位的数
        }
        if (t != 0) c.add(t); //当加法结束，可能需要进位
        return c;
    }

    // C = A - B, 满足A >= B, A >= 0, B >= 0
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
        while(c.size()>1&&c.get(c.size()-1)==0) c.remove(c.size()-1);
        return c;
    }
}
