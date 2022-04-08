package base;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Case797
 * @Description 差分
 * @Author SiYiXiong
 * @Date 2022/4/2 16:42
 * @Version v0.1
 **/
public class Case797 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] array = new int[n + 2];
        Arrays.fill(array, 0);
        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            array[i] = array[i] + x;
            array[i + 1] = array[i + 1] - x;
        }
        for (int i = 0; i < m; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int c = sc.nextInt();
            array[l] = array[l] + c;
            array[r + 1] = array[r + 1] - c;
        }
        for (int i = 1; i <= n; i++) {
            array[i] = array[i] + array[i - 1];
            System.out.print(array[i] + " ");
        }
    }
}
