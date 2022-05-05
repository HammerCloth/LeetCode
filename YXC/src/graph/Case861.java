package graph;

import java.io.BufferedInputStream;
import java.util.*;

/**
 * @ClassName Case861
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/29 08:10
 * @Version v0.1
 **/
public class Case861 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n1 = sc.nextInt();//表示第一个集合中的点数
        int n2 = sc.nextInt();//表示第二个集合中的点数
        int m = sc.nextInt();
        HashMap<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;//左半部的点,从0开始
            int b = sc.nextInt() - 1;//右半部的点，从0开始
            if (!graph.containsKey(a)) {
                graph.put(a, new HashSet<>());
                graph.get(a).add(b);
            } else {
                graph.get(a).add(b);
            }
        }
        int N = n1 + n2;
        System.out.println(maxMatch(graph, N));
    }

    public static int maxMatch(HashMap<Integer, Set<Integer>> graph, int N) {
        int[] match = new int[N];
        Arrays.fill(match, -1);
        //求最大匹配数，依次枚举第一个集合中每个点能否匹配第二个集合中的点
        int res = 0;
        //为每一个男嘉宾匹配女生，但是先来的男嘉宾有优先选择权
        for (int i = 0; i < graph.size(); i++) {
            boolean[] state = new boolean[N];
            if (find(graph, i, state, match)) res++;
        }
        return res;
    }

    /**
     * 通过递归的方法来找到匹配
     * @param graph 用于存储二分图
     * @param i 男嘉宾编号
     * @param state 用于表示这个男生的女生选择，如果state为false表示可以选择，如果state为true表示不可以选择
     * @param match 用于存储整个配对情况
     * @return 是否该男生可以配对成功
     */
    public static boolean find(HashMap<Integer, Set<Integer>> graph, int i, boolean[] state, int[] match) {
        for (int next : graph.get(i)) {//获取这个点所能连接到的点
            if (!state[next]) {
                state[next] = true;//先尝试和这个女生在一起
                //如果这个女生没有对象，或者这个女生的男朋友可以去找其他女生作为对象
                if (match[next] == -1 || find(graph, match[next], state, match)) {
                    //我们就和这个女生在一起
                    match[next] = i;
                    return true;
                }
            }
        }
        return false;
    }
}
