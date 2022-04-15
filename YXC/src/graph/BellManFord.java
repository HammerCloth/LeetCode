package graph;

import java.io.BufferedInputStream;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName BellManFord
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/13 08:33
 * @Version v0.1
 **/
public class BellManFord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        edge[] list = new edge[m];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            int c = sc.nextInt();
            list[i] = new edge(a,b,c);
        }
        int result = bellman_ford(n, k, m, list);
        if (result==-1){
            System.out.println("impossible");
        }
        System.out.println(result);
    }

    public static int bellman_ford(int n,int k,int m,edge[] list){
        //建立辅助数组
        int[] dist = new int[n];//0下标开始
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0;
        //主体逻辑
        for (int i = 0; i < k; i++) {
            int[] clone = dist.clone();//防止串联更新，稳定更新步数
            for (int j = 0; j < m; j++) {
                edge edge = list[j];
                if (clone[edge.a]!=Integer.MAX_VALUE){
                    dist[edge.b] = Math.min(dist[edge.b],clone[edge.a]+ edge.w);
                }
            }
        }
        if (dist[n-1]>Integer.MAX_VALUE/2) return -1;
        return dist[n-1];

    }
    static class edge{
        int a;
        int b;
        int w;
        public edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }

        public edge() {
        }
    }
}
