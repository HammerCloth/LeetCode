package base;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @ClassName Case795
 * @Description 前缀和
 * @Author SiYiXiong
 * @Date 2022/4/2 14:57
 * @Version v0.1
 **/
public class Case795 {
    public static void main(String[] args){
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] array = new int[n+1];
        array[0] = 0;
        for(int i= 1;i<=n;i++) array[i] = sc.nextInt()+array[i-1];
        for (int i = 0; i < m; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int x = array[r]-array[l-1];
            System.out.println(x);
        }
    }

}
