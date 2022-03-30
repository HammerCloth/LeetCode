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
        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new HashMap<>());
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.get(x).put(y, 1);
        }
        System.out.println(bfs(graph));
    }

    /**
     * 树和图的广度优先遍历
     * @param graph 图
     * @return 返回到达最后一个点的路径长度
     */
    public static int bfs(HashMap<Integer, HashMap<Integer, Integer>> graph) {
        //声明所需要的辅助数组，队列
        boolean[] help = new boolean[graph.size() + 1];
        Queue<Integer> queue = new LinkedList<>();
        //将第一个节点放入队列中，并将状态更新
        help[1] = true;
        queue.offer(1);
        int level = 0;
        //当队列为空的时候停止
        while (!queue.isEmpty()) {
            // 发现n遍历到了，及时返回
            if (help[graph.size()]) return level;
            //提前拿到size，防止在遍历的时候个数发生变化
            int size = queue.size();
            //每次将这一层的所有节点遍历完，才能level++
            for (int j = 0; j < size; j++) {
                int temp = queue.poll();
                for (int i : graph.get(temp).keySet()) {
                    if (!help[i]) {
                        help[i] = true; 
                        queue.offer(i);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
