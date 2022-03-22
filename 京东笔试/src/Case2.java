import java.io.BufferedInputStream;
import java.util.*;

/**
 * @ClassName Case2
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/3/19 20:01
 * @Version v0.1
 **/

public class Case2 {
    static class Node{
        int val;
        HashMap<Integer,Integer> next;

        public Node(int val) {
            this.val = val;
            next =new HashMap<>();
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();//点的个数
        int m = sc.nextInt();//边的数量
        HashMap<Integer,Node> graph = new HashMap<>();
        for (int i = 1; i <=n ; i++) {
            graph.put(i,new Node(i));
        }
        List<List<Integer>> input = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int p = sc.nextInt();
            if(u==v) continue;
            graph.get(u).next.put(v,p);
            graph.get(v).next.put(u,p);
            List<Integer> temp = new ArrayList<>();
            temp.add(u);
            temp.add(v);
            temp.add(p);
            input.add(temp);
        }
        int result = -1;
        for(List<Integer> temp:input){
            result = Math.max(result,result(temp.get(0),temp.get(1),temp.get(2),n,graph));
        }
        System.out.println(result);

    }
    public static int result(int maxU,int maxV,int maxP,int n,HashMap<Integer,Node> graph){
        Set<Integer> point = new HashSet<>();
        point.add(maxU);
        point.add(maxV);
        int result = maxP;
        while(point.size()<n){
            for(int i:point){
                maxU = -1;
                maxV = -1;
                maxP = -1;
                Node temp = graph.get(i);
                for(int j:temp.next.keySet()){
                    if(!point.contains(j)){
                        if(maxP<temp.next.get(j)){
                            maxU = i;
                            maxV = j;
                            maxP = temp.next.get(j);
                        }
                    }
                }
            }
            point.add(maxV);
            result = Math.min(result,maxP);
        }
        return result;
    }


}
