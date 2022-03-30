package graph;

import java.io.BufferedInputStream;
import java.util.*;

/**
 * @ClassName Topo
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/3/28 22:47
 * @Version v0.1
 **/
public class Topo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> in = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new HashMap<>());
            in.put(i, 0);
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            //防止重边，影响入度
            if (!graph.get(x).containsKey(y)) {
                graph.get(x).put(y, 1);
                in.put(y, in.get(y) + 1);
            }
        }
        if (!topo(graph, in)) {
            System.out.println(-1);
        }
    }

    /**
     * topo排序
     * @param graph 存储图
     * @param in 存储入度
     * @return 返回是否存在topo排序
     */
    public static boolean topo(HashMap<Integer, HashMap<Integer, Integer>> graph, HashMap<Integer, Integer> in) {
        //辅助数组，确认点是否遍历过，防止回环
        boolean[] help = new boolean[in.size() + 1];
        //辅助队列，进行层序遍历
        Queue<Integer> queue = new LinkedList<>();
        //辅助数组，保存排序后的顺序
        List<Integer> list = new ArrayList<>();

        //将所有的入度为0的点入队，作为起始点，同时初始化辅助数组help
        for (int i = 1; i <= in.size(); i++) {
            if (in.get(i) == 0) queue.offer(i);
            help[i] = true;
        }
        //层序遍历模版
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer temp = queue.poll(); //出队
                list.add(temp);//在数组中保存
                help[temp] = false;//设置状态
                for (int j : graph.get(temp).keySet()) {
                    //将这个点所串联的所有的点，如果没有遍历过，就将入度减1，并且判断入度是否为0
                    if (help[j]) {
                        in.put(j, in.get(j) - 1);
                        if (in.get(j) == 0) {
                            queue.offer(j);//入度为0则入队
                        }
                    }
                }
            }
        }
        //如果保存排序的数组的长度和入度长度一致，则说明有topo排序
        if (list.size() == in.size()) {
            list.stream().forEach((i) -> {
                System.out.print(i + " ");
            });
            return true;
        }
        return false;
    }
}
