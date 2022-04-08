package base;

import java.io.BufferedInputStream;
import java.util.*;

/**
 * @ClassName HighPrecisionDiv
 * @Description 高精度除法
 * @Author SiYiXiong
 * @Date 2022/4/1 10:11
 * @Version v0.1
 **/
public class HighPrecisionDiv {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        char[] chars = sc.nextLine().toCharArray();
        List<Integer> a = new ArrayList<>();
        for (int i = chars.length - 1; i >= 0; i--) a.add(chars[i] - '0');
        int b = sc.nextInt();
        List<Integer> c = div(a, b);
        for (int i = c.size() - 1; i >= 0; i--) System.out.print(c.get(i));
        System.out.println();
        System.out.println(t);
    }


    static int t = 0;
    public static List<Integer> div(List<Integer> a, int b) {
        List<Integer> c = new ArrayList<>();
        for (int i = a.size() - 1; i >= 0; i--) { //应为存储的方式，所以要从高位开始除
            t = t * 10 + a.get(i); //计算被除数
            c.add(t/b); //除上除数，获得结果中的一位，这里可以求得一定是个位的
            t %= b;//获得余数，用于组合下一次的被除数，如果按位除完，t就变成了余数
        }
        Collections.reverse(c); //保证我们存储的顺序
        while (c.size() > 1 && c.get(c.size()-1) == 0) c.remove(c.size()-1);//去除前置0
        return c;
    }
}
