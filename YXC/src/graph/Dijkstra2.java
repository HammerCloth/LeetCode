package graph;

import java.io.BufferedInputStream;
import java.util.*;

/**
 * @ClassName Dijkstra2
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/8 16:49
 * @Version v0.1
 **/
public class Dijkstra2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashMap<>());
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            int z = sc.nextInt();
            if (graph.get(x).containsKey(y)) {
                graph.get(x).put(y, Math.min(graph.get(x).get(y), z));
            } else {
                graph.get(x).put(y, z);//重边和自环如何处理
            }
        }
        System.out.println(dijkstra(graph, 0, n - 1, n));
    }

    public static int dijkstra(HashMap<Integer, HashMap<Integer, Integer>> graph, int start, int end, int n) {
        //-----------------------------------------------------------------------------------准备辅助数组并初始化
        //用于保存到达各个点的最短距离
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        //用于保存各个点是否已经到过
        boolean[] flag = new boolean[n];
        //创建小顶堆，用于优化寻找最近点的逻辑
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        heap.offer(new int[]{0, start});//队列初始化只需要加入第一个值即可，也可以添加所有的值，但是没有必要
        //---------------------------------------------------------------循环获得最短路，当最短路全部求出时，堆也会逐渐排空
        while (!heap.isEmpty()) {
            int[] top = heap.poll();
            int var = top[1]; //当前最近点的序号
            int distance = top[0];//当前最近点的路径

            if (flag[var]) continue;//如果该点已经遍历过则直接排除该点
            flag[var] = true;//标记该点
            //找出该点的所有可达的点
            for (int i : graph.get(var).keySet()) {
                int w = graph.get(var).get(i);
                if (dist[i] > distance + w) {
                    dist[i] = distance + w;
                    heap.offer(new int[]{dist[i], i});
                }
            }
        }
        if (dist[end] == Integer.MAX_VALUE) return -1;
        return dist[end];
    }

}
