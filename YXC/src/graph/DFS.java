package graph;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @ClassName DFS
 * @Description 树和图的深度优先遍历
 * @Author SiYiXiong
 * @Date 2022/3/21 15:47
 * @Version v0.1
 **/
public class DFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();//点的个数
        int m = sc.nextInt();//边的个数
        //HashMap<点，HashMap<点，到这个点的距离>>
        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
        //根据所给的点的信息来初始化图
        for (int i = 1; i <= n; i++) {
            graph.put(i, new HashMap<>());
        }
        //根据输入来构造图
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int p = sc.nextInt();
            //有向图
            graph.get(u).put(v, p);
            //无向图
            //graph.get(u).put(v,p);
            //graph.get(v).put(u,p);
        }
        boolean[] flag = new boolean[n + 1];
        Arrays.fill(flag, false);
        System.out.println(dfs(graph, 1, flag));
    }

    public static int dfs(HashMap<Integer, HashMap<Integer, Integer>> graph, int start, boolean[] flag) {
        //标记访问
        flag[start] = true;
        int reuslt = 1;
        //对所有可能有的结果进行遍历
        for (int key : graph.get(start).keySet()) {
            //如果这个节点没有访问过，则从这个节点开始进行dfs
            if (!flag[key]) reuslt += dfs(graph, key, flag);
        }
        return reuslt;
    }
}
