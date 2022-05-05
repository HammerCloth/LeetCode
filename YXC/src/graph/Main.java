package graph;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N = 510, INF = 0x3f3f3f3f;
    static int n, m;
    static int[][] g = new int[N][N];
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];

    private static int prime() {
        Arrays.fill(dist, INF);

        int res = 0;
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!st[j] && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }
            System.out.println("point"+t);
            if (i != 0 && dist[t] == INF) return INF;
            if (i != 0) {
                res += dist[t];
            }
            System.out.println(res);
            for (int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[j], g[t][j]);
            }
            st[t] = true;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < N; i++) {
            Arrays.fill(g[i], INF);
        }
        while (m-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            g[a][b] = g[b][a] = Math.min(g[a][b], c);
        }

        int t = prime();
        if (t == INF) System.out.println("impossible");
        else System.out.println(t);
    }
}