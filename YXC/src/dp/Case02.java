package dp;

import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @ClassName Case02
 * @Description 01背包问题
 * @Author SiYiXiong
 * @Date 2022/4/29 15:35
 * @Version v0.1
 **/
public class Case02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int N = sc.nextInt();//物品数量
        int V = sc.nextInt();//背包容积
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();
            int v = sc.nextInt();
            map.put(n,v);
        }
        
    }
}
