package graph;

import java.io.BufferedInputStream;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

/**
 * @ClassName Kruska
 * @Description Kruska算法
 * @Author SiYiXiong
 * @Date 2022/4/26 14:31
 * @Version v0.1
 **/
public class Kruska {
    //初始化并查集
    static int[] set;

    static int find(int x) {
        if (set[x] != x) set[x] = find(set[x]);
        return set[x];
    }

    //建立edge，用于存储边的信息
    static class Edge {
        int a;
        int b;
        int w;

        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int m = sc.nextInt();
        //根据边的个数来初始化并查集，可以防止浪费多余的空间
        set = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            set[i] = i;
        }
        //初始化小顶堆用于将边按照权限从小到大排序
        PriorityQueue<Edge> heap = new PriorityQueue<>((o1, o2) -> {
            return o1.w - o2.w;
        });
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
            heap.add(new Edge(a, b, w));
        }
        //res存储生成树的权之和，count存储边的个数
        int res = 0;
        int count = 1;
        for (int i = 0; i < m; i++) {
            Edge poll = heap.poll();
            //如果a和b不是一个集合，那么将a和b所在的集合合并
            if (find(poll.a) != find(poll.b)) {
                set[find(poll.a)] = find(poll.b);
                res += poll.w;
                count++;
            }
        }
        if (count != n) System.out.println("impossible");
        else System.out.println(res);
    }


}
