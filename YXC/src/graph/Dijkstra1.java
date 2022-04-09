package graph;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Dijkstra1
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/6 17:21
 * @Version v0.1
 **/
public class Dijkstra1 {
    public static void main(String[] args) {
        double positiveInfinity = Double.POSITIVE_INFINITY;
        positiveInfinity++;
        System.out.println(positiveInfinity);
        System.out.println(positiveInfinity == Double.POSITIVE_INFINITY);
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt(); //n个点
        int m = sc.nextInt(); //m条边
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;//转化从0开始
            int y = sc.nextInt() - 1;//转化从0开始
            int c = sc.nextInt();
            graph[x][y] = Math.min(graph[x][y], c);
        }
        System.out.println(dijkstra(graph, 0, n - 1, n));
    }

    /**
     * 朴素dijksstra算法
     * @param graph 使用邻接矩阵来存储图的信息
     * @param start 表示最短路的起点
     * @param end 表最短路的终点
     * @param n 图中一共有n个点
     * @return 最短路的长度
     */
    public static int dijkstra(int[][] graph, int start, int end, int n) {

        //初始化距离数组
        int[] dist = new int[n];//因为double数组存在无限大
        Arrays.fill(dist, Integer.MAX_VALUE);//表示无穷大
        dist[start] = 0; //起点距离为0

        //初始化flag表示是否被遍历
        boolean[] flag = new boolean[n];

        //开始迭代求start到所有点的距离
        for (int i = 0; i < n; i++) {
            //从还没有确定最短路的点中，寻找距离最小的点
            int t = -1;
            for (int j = 0; j < n; j++) {
                if (!flag[j] && (t == -1 || dist[t] > dist[j])) t = j;
            }
            //用t来更新其他点的距离
            for (int j = 0; j < n; j++) {
                if (graph[t][j]!=Integer.MAX_VALUE)
                    dist[j] = Math.min(dist[j], dist[t] + graph[t][j]);
            }
            //t点标记为已经过
            flag[t] = true;
        }
        if (dist[end] == Integer.MAX_VALUE) return -1;
        return dist[end];
    }
}
