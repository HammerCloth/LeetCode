package base;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Case798
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/6 15:13
 * @Version v0.1
 **/
public class Case798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int m = sc.nextInt();//接下来 n 行，每行包含 m 个整数，表示整数矩阵。
        int q = sc.nextInt();//接下来 q 行，每行包含 5 个整数 x1,y1,x2,y2,c，表示一个操作。

        //创建差分数组，进行初始化；
        int[][] array = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //认为x1 = x2 y1 = y2
                int c = sc.nextInt();
                array[i][j] += c;
                array[i + 1][j] -= c;
                array[i][j + 1] -= c;
                array[i + 1][j + 1] += c;
            }
        }
        //进行操作
        for (int i = 0; i < q; i++) {
            int x1 = sc.nextInt() - 1;
            int y1 = sc.nextInt() - 1;
            int x2 = sc.nextInt() - 1;
            int y2 = sc.nextInt() - 1;
            int c = sc.nextInt();
            array[x2 + 1][y1] -= c;
            array[x1][y2 + 1] -= c;
            array[x2 + 1][y2 + 1] += c;
            array[x1][y1] += c;
        }
        // 求取前缀和
        int[][] result = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                result[i][j] = array[i - 1][j - 1] + result[i][j - 1];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                result[j][i] = result[j - 1][i] + result[j][i];
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
