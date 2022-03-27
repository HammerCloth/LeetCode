package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @ClassName BFS
 * @Description
 * @Author SiYiXiong
 * @Date 2022/3/26 09:59
 * @Version v0.1
 **/
public class BFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<Integer,HashMap<Integer,Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i,new HashMap<>());
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.get(x).put(y,1);
        }
        bfs(graph,n);
    }
    public static void bfs(HashMap<Integer, HashMap<Integer,Integer>> graph,int n){
        boolean[] help = new boolean[graph.size()+1];
        Queue<Integer> queue = new LinkedList<>();
        help[1] = true;
        queue.offer(1);
        int result = -1;
        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(int i:graph.get(temp).keySet()){
                if (i==n){
                    System.out.println(result + 2);
                    return;
                }
                if (!help[i]){
                    help[i] = true;
                    queue.offer(i);
                }
            }
            result++;
        }
        System.out.println(-1);
    }
}
