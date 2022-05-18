import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @ClassName Case433
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/5/7 09:36
 * @Version v0.1
 **/
public class Case433 {
    public static void main(String[] args) {
        System.out.println(minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"}));
    }
    public static int minMutation(String start, String end, String[] bank) {
        //层次遍历
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();//防止多次访问
        queue.offer(start);
        set.add(start);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                String temp = queue.poll();
                for (int j = 0; j < bank.length; j++) {
                    //可以进行变化，并且没有经过
                    if (check(temp,bank[j])&&!set.contains(bank[j])){
                        if (bank[j]==end) return level;
                        queue.offer(bank[j]);
                        set.add(bank[j]);
                    }
                }
            }
        }
        return -1;

    }

    //表示是否是可以到达的格子
    public static boolean check(String start,String end){
        char[] stars = start.toCharArray();
        char[] ends = end.toCharArray();
        int count = 0;
        for (int i = 0; i < 8; i++) {
            if (stars[i]!=ends[i]){
                count++;
                if (count>1) return false;
            }
        }
        return true;
    }
}
