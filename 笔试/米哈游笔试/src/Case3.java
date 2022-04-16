import jdk.jfr.internal.tool.Main;

import java.io.BufferedInputStream;
import java.util.*;

/**
 * @ClassName Case3
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/3/20 20:19
 * @Version v0.1
 **/
public class Case3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int k = sc.nextInt();
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int i = 1; i <=n ; i++) {
            graph.put(i,new ArrayList<>());
        }
        int[] len = new int[n+1];
        Arrays.fill(len,0);
        for (int i = 1; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.get(x).add(y);
            graph.get(y).add(x);
            len[x]++;
            len[y]++;
        }
        System.out.println(result(graph,len,0,k));

    }

    public static int result(HashMap<Integer, ArrayList<Integer>> graph,int[] len,int key,int k){
        if(check(graph, len, k)) return 1;
        for (int i = 1; i < len.length; i++) {
            if (len[i]==1){//叶子节点
                len[i]=0;
                ArrayList<Integer> temp = graph.get(i);
                graph.put(i,new ArrayList<>());
                key += result(graph, len, key,k);
                graph.put(i,temp);
                len[i]=1;
            }
        }
        return key;
    }

    public static boolean check(HashMap<Integer, ArrayList<Integer>> graph,int[] len,int k){
        int level = 0;
        for (int i = 0; i < len.length; i++) {
            if (len[i]==1){
                level = Math.max(level,bfs(graph,i));
            }
        }
        if (level<=k) return true;
        else return false;
    }
    public static int bfs(HashMap<Integer, ArrayList<Integer>> graph,int start){
        int[] cac = new int[graph.size()+1];
        cac[0] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        cac[start] = 1;
        int level = 0;
        while(!queue.isEmpty()){
            level++;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                Integer poll = queue.poll();
                ArrayList<Integer> list = graph.get(poll);
                for(int i:list){
                    if(cac[i]==0){
                        queue.offer(i);
                        cac[i]=1;
                    }
                }
            }
        }
        System.out.println(level-1);
        return level-1;
    }
}
