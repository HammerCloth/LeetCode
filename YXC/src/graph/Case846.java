package graph;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @ClassName Case846
 * @Description 树的重心
 * @Author SiYiXiong
 * @Date 2022/3/21 16:49
 * @Version v0.1
 **/
public class Case846 {
    public static int nvm = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
        //初始化
        for (int i = 1; i <= n; i++) {
            graph.put(i, new HashMap<>());
        }
        //处理输入
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).put(b, 1);
            graph.get(b).put(a, 1);
        }
        boolean[] help = new boolean[n + 1];
        dfs(graph, 1, help);
        System.out.println(nvm);
    }

    public static int dfs(HashMap<Integer, HashMap<Integer, Integer>> graph, int start, boolean[] visited) {
        //标记访问
        visited[start] = true;
        int count = 0;
        int sum = 1;
        //对所有可能对结果进行遍历
        for (int i : graph.get(start).keySet()) {
            //只有没有访问对结果才会进行dfs
            if (!visited[i]) {
                int temp = dfs(graph, i, visited);
                count = Math.max(temp, count);
                sum += temp;
            }
        }
        int other = graph.size() - sum;
        count = Math.max(other, count);
        nvm = Math.min(nvm, count);
        return sum;
    }

}
