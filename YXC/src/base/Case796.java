package base;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Case796
 * @Description 子矩阵的和
 * @Author SiYiXiong
 * @Date 2022/4/2 15:39
 * @Version v0.1
 **/
public class Case796 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        int[][] array = new int[n + 1][m + 1];
        Arrays.fill(array[0], 0);
        for (int i = 1; i <= n; i++) array[n][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                array[i][j] = sc.nextInt() + array[i][j - 1];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                array[j][i] = array[j][i] + array[j - 1][i];
            }
        }

        for (int i = 0; i < q; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int x = array[x2][y2] - array[x1-1][y2]-array[x2][y1-1]+array[x1-1][y1-1];
            System.out.println(x);
        }
    }
}
