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
        List<Integer> c = null;
        if (a.size() > b.size()) {
            c = sub(a, b);
        } else if (a.size() < b.size()) {
            c = sub(b, a);
            System.out.print('-');
        } else {
            for (int i = a.size() - 1; i >= 0; i--) {
                if (a.get(i) > b.get(i)) {
                    c = sub(a, b);
                    break;
                } else if (a.get(i) < b.get(i)) {
                    System.out.print("-");
                    c = sub(b, a);
                    break;
                }
            }
            if (c == null) {
                c = sub(a, b);
            }
        }
        for (int i = c.size() - 1; i >= 0; i--) System.out.print(c.get(i));

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
        while (c.size() > 1 && c.get(c.size() - 1) == 0) c.remove(c.size() - 1);
        return c;
    }
}
