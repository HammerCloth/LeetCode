import sun.nio.cs.ext.MacHebrew;

import java.util.HashMap;

/**
 * @ClassName Case2
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/17 10:56
 * @Version v0.1
 **/
public class Case2 {
    public static void main(String[] args) {
//        for (int i = 1; i < 10000; i++) {
//            System.out.println(cut(i));
//        }
        System.out.println(minimumRounds(new int[]{2, 2, 3, 3, 2, 4, 4, 4, 4, 4}));
    }
    public static int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            if (map.containsKey(tasks[i])){
                map.put(tasks[i],map.get(tasks[i])+1);
            }else{
                map.put(tasks[i],1);
            }
        }
        int count = 0;
        for (int k:map.keySet()){
            if (map.get(k)==1){
                return -1;
            }else{
                count+=cut(map.get(k));
            }
        }
        return count;
    }

    public static int cut(int take) {
        if (take==1) return Integer.MAX_VALUE/2;
        if (take==2) return 1;
        if (take==3) return 1;
        int[] help = new int[take+1];
        help[1] = Integer.MAX_VALUE/2;
        help[2] = 1;
        help[3] = 1;
        for (int i = 4; i <=take ; i++) {
            help[i] = Math.min(help[i-3],help[i-2])+1;
        }
        return help[take];
    }
}
