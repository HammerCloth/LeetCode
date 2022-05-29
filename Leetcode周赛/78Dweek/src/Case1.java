import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Case1
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/5/14 22:24
 * @Version v0.1
 **/
public class Case1 {
    public static void main(String[] args) {
        int[][] x = new int[][]{{0,1},{1, 2},{2,3},{0,2},{1,3},{2,4}};
        System.out.println(maximumImportance(5, x));
    }
    public static long maximumImportance(int n, int[][] roads) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < roads.length; i++) {
            int a = roads[i][0];
            int b = roads[i][1];
            if (map.containsKey(a)){
                map.get(a).add(b);
            }else{
                HashSet<Integer> set = new HashSet<>();
                set.add(b);
                map.put(a,set);
            }
            if (map.containsKey(b)){
                map.get(b).add(a);
            }else{
                HashSet<Integer> set = new HashSet<>();
                set.add(a);
                map.put(b,set);
            }
        }
        boolean[] help = new boolean[n];
        return maximumImportance(n-1,map,help);

    }
    public static long maximumImportance(int n, HashMap<Integer, Set<Integer>> map,boolean[] help){
        if (n==0){
            long result = 0;
            for (Integer i : map.get(0)) {
                if (!help[i]){
                    result = Math.max(result,i);
                }
            }
        }
        long result = 0;
        for (Integer i : map.get(n)) {
            if (!help[i]){
                help[i] = true;
                result = Math.max(result,n+i+maximumImportance(n-1,map,help));
                help[i] = false;
            }
        }
        return result;
    }
}
