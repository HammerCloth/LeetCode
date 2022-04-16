package graph;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @ClassName Floyd
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/16 20:52
 * @Version v0.1
 **/
public class Floyd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) graph[i][j] = 0;
                else graph[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            int w = sc.nextInt();
            graph[x][y] = Math.min(w, graph[x][y]);
        }
        floyd(graph, n);
        for (int i = 0; i < k; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            if (graph[x][y] >= Integer.MAX_VALUE / 2) {
                System.out.println("impossible");
            } else {
                System.out.println(graph[x][y]);
            }
        }

    }

    public static void floyd(int[][] graph, int n) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE)
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
    }
}
