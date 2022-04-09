package graph;

import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @ClassName Dijkstra2
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/8 16:49
 * @Version v0.1
 **/
public class Dijkstra2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<Integer,HashMap<Integer,Integer>> graph = new HashMap<>();
        for (int i = 1; i <=n ; i++) {
            graph.put(i,new HashMap<>());
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
        }
    }
}
