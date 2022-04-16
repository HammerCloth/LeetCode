package graph;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @ClassName SPFA
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/15 22:27
 * @Version v0.1
 **/
public class SPFA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<Integer,HashMap<Integer,Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n ; i++) {
            graph.put(i,new HashMap<>());
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
            if (graph.get(a).containsKey(b)){
                graph.get(a).put(b,Math.min(graph.get(a).get(b),w));
            }else{
                graph.get(a).put(b,w);
            }
        }
        int spfa = spfa(graph, 1, n);
        if (spfa==-1){
            System.out.println("impossible");
        }else{
            System.out.println(spfa);
        }
    }
    public static int spfa(HashMap<Integer,HashMap<Integer,Integer>> graph,int start,int end){
        //初始化距离数组
        int[] dist = new int[graph.size()+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        //初始化队列
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(start);
        //建立访问数组，提升效率
        boolean[] flag = new boolean[graph.size()+1];
        flag[start] = true;
        //循环队列
        while(!queue.isEmpty()){
            //取出队列中的一个数，并标记不再队列中
            int a = queue.poll();
            flag[a] = false;
            //遍历这个节点的所有出度用于更新所有点的边
            for (Integer b : graph.get(a).keySet()) {
                int newD = dist[a] + graph.get(a).get(b);
                //如果可以更新，则判断这个节点是否在队列中，然后加入队列
                if(dist[b]>newD){
                    dist[b] = newD;
                    if (!flag[b]){
                        queue.offer(b);
                        flag[b] = true;
                    }
                }
            }
        }
        if (dist[end]>=Integer.MAX_VALUE/2) return -1;
        return dist[end];
    }
}
