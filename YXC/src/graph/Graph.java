package graph;

import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @ClassName Graph
 * @Description 图的邻接表表示
 * @Author SiYiXiong
 * @Date 2022/3/20 16:52
 * @Version v0.1
 **/
public class Graph {
    public static void main(String[] args){
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();//点的个数
        int m = sc.nextInt();//边的个数
        //HashMap<点，HashMap<点，到这个点的距离>>
        HashMap<Integer,HashMap<Integer,Integer>> graph = new HashMap<>();
        //根据所给的点的信息来初始化图
        for (int i = 1; i <= n; i++) {
            graph.put(i,new HashMap<>());
        }
        //根据输入来构造图
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int p = sc.nextInt();
            //有向图
            graph.get(u).put(v,p);
            //无向图
            //graph.get(u).put(v,p);
            //graph.get(v).put(u,p);
        }
    }

}

