package graph;

import java.io.BufferedInputStream;
import java.util.*;

/**
 * @ClassName Case860
 * @Description 染色法判断二分图
 * @Author SiYiXiong
 * @Date 2022/4/26 15:48
 * @Version v0.1
 **/
public class Case860 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int m = sc.nextInt();
        //初始化图
        HashMap<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        boolean check = check(graph);
        if (check) System.out.println("Yes");
        else System.out.println("No");
    }

    public static boolean check(HashMap<Integer, Set<Integer>> graph) {
        //建立辅助数组，保存颜色信息，-1表示没有颜色
        int n = graph.size();
        int[] color = new int[n + 1];//+1用来矫正下标
        Arrays.fill(color, -1);
        //对每一天开始dfs染色
        for (int i = 1; i < n; i++) {
            if (color[i] == -1) {//如果是-1表示没有染色
                //递归染色
                boolean dfs = dfs(graph, i, color, 1);
                if (!dfs) return dfs;
            }
        }
        return true;
    }


    public static boolean dfs(HashMap<Integer, Set<Integer>> graph, int i, int[] color, int c) {
        //1,2，表示不同的颜色
        color[i] = c;//进行染色
        int next = 3 - c;
        //找到下一层的节点
        for (int k : graph.get(i)) {
            //如过下一个点还没有颜色，则递归
            if (color[k] == -1) {
                boolean dfs = dfs(graph, k, color, next);
                if (!dfs) return dfs;
            }else{
                //染色则直接跳过嘛，说明已经dfs过了
                 if (color[k] != next){
                     return false;
                 }
            }
        }
        return true;
    }
}
