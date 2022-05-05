package graph;

import javax.print.DocFlavor;
import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @ClassName prime
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/21 11:03
 * @Version v0.1
 **/
public class prim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int m = sc.nextInt();
        double[][] graph = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] =Double.POSITIVE_INFINITY;
            }
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt()-1;
            int v = sc.nextInt()-1;
            int w = sc.nextInt();
            graph[u][v] =graph[v][u]= Math.min(graph[u][v],w);
        }
        int prim = prim(graph, n);
        if (prim==Integer.MAX_VALUE) System.out.println("impossible");
        else System.out.println(prim);
    }
    /**
     * 最小生成树算法
     *
     * @param graph 使用邻接矩阵表示的图，一般是稠密图
     * @param n     图中点的个数
     * @return 计算出的最小生成树的权重和
     */
    public static int prim(double[][] graph, int n) {
        //定义一个表示点到图的距离的数组，使用double是因为存在正无穷
        double[] dist = new double[n];
        Arrays.fill(dist, Double.POSITIVE_INFINITY);
        //定义一个state保存节点状态，不实用set可以减少复杂度
        boolean[] state = new boolean[n];
        //定义结果，用于保存最小生成树的权之和
        int res = 0;
        //循环n次
        for (int i = 0; i < n; i++) {
            int t = -1;
            //找到距离图最近的点，当图没有一个点的时候，就是0点
            for (int j = 0; j < n; j++) {
                if (!state[j] && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }
            //如果是不是第一个点，并且图到达这个点的距离是无穷，说明没有最短生成树，返回无穷
            if (i != 0 && dist[t] == Double.POSITIVE_INFINITY) return Integer.MAX_VALUE;
            //如果不是第一个点的话，将边权加入到res中，第一个点是起点，没有边的
            if (i != 0) res += dist[t];
            //将点加入图中
            state[t] = true;
            //用这个点更新所有边
            for (int j = 0; j < n; j++) {
                dist[j] = Math.min(dist[j], graph[t][j]);
            }
        }
        return res;
    }
}
