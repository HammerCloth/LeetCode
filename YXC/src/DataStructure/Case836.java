package DataStructure;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @ClassName Case836
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/23 10:29
 * @Version v0.1
 **/
public class Case836 {
    /**
     * int p[N]; //存储每个点的祖宗节点
     * <p>
     * // 返回x的祖宗节点
     * int find(int x)
     * {
     * if (p[x] != x) p[x] = find(p[x]);
     * return p[x];
     * }
     * <p>
     * // 初始化，假定节点编号是1~n
     * for (int i = 1; i <= n; i ++ ) p[i] = i;
     * <p>
     * // 合并a和b所在的两个集合：
     * p[find(a)] = find(b);
     */
    static int N = 100010;
    static int[] set = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            set[i] = i;
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String s = sc.next();
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            if (s.equals("M")) {
                set[find(a)] = find(b);
            } else {
                if (find(a) == find(b)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }

    public static int find(int x) {
        if (set[x] != x) set[x] = find(set[x]);
        return set[x];
    }

}
