package DataStructure;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @ClassName Case837
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/23 11:07
 * @Version v0.1
 **/
public class Case837 {
    static int N = 100010;
    static int[] set = new int[N];
    static int[] size = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            set[i] = i;
            size[i] = 1;
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String next = sc.next();
            if (next.equals("C")){
                int a = sc.nextInt()-1;
                int b = sc.nextInt()-1;
                if (a!=b&&find(a)!=find(b)){
                    size[find(b)]+=size[find(a)];
                    set[find(a)] = find(b);
                }
            } else if (next.equals("Q1")) {
                int a = sc.nextInt()-1;
                int b = sc.nextInt()-1;
                if (find(a)==find(b)){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            }else{
                int a = sc.nextInt()-1;
                System.out.println(size[find(a)]);
            }
        }
    }

    public static int find(int x){
        if (set[x]!=x) set[x] = find(set[x]);
        return set[x];
    }
}
