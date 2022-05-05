package graph;

import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @ClassName Case852
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/16 11:29
 * @Version v0.1
 **/
public class Case852 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new HashMap<>());
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
            if (graph.get(a).containsKey(b)) {
                graph.get(a).put(b, Math.min(graph.get(a).get(b), w));
            } else {
                graph.get(a).put(b, w);
            }
        }
        boolean spfa = spfa(graph);
        if (spfa){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }

    public static boolean spfa(HashMap<Integer, HashMap<Integer, Integer>> graph) {
        //dist初始化为全部为0
        int[] dist = new int[graph.size() + 1];
        //初始化队列和访问数组
        boolean[] flag = new boolean[graph.size() + 1];
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i <= graph.size(); i++) {
            queue.offer(i);
            flag[i] = true;
        }
        //初始化边数的数组
        int[] help = new int[graph.size() + 1];
        while (!queue.isEmpty()) {
            Integer a = queue.poll();
            flag[a] = false;
            for (Integer b : graph.get(a).keySet()) {
                Integer weight = graph.get(a).get(b) + dist[a];
                if (dist[b]>weight) {
                    dist[b] = weight;
                    help[b]+=1;
                    if (help[b] >= graph.size()) return true;//存在负环
                    if (!flag[b]) {
                        queue.offer(b);
                        flag[b] = true;
                    }
                }
            }
        }
        return false;//不存在负环
    }
}
