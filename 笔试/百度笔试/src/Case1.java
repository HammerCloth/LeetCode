import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @ClassName Case1
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/3/22 19:37
 * @Version v0.1
 **/
public class Case1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {//每一行
            for (int j = 0; j < k; j++) { //画k行
                for (int l = 0; l < n; l++) { //每一行的每一个
                    for (int m = 0; m < k; m++) { //画k遍
                        System.out.print(graph[i][l]+" ");
                    }
                }
                System.out.println();
            }
        }
    }
}
