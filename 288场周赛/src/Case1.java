import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName Case1
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/10 10:18
 * @Version v0.1
 **/
public class Case1 {
    public static void main(String[] args) {
        System.out.println(largestInteger(65875));
    }
    public static int largestInteger(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        boolean[] flag = new boolean[chars.length];
        PriorityQueue<Integer> ou = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        PriorityQueue<Integer> ji = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < chars.length; i++) {
            int k = chars[i]-'0';
            if (k%2==0){
                flag[i] = true;
                ou.offer(k);
            }else{
                flag[i] = false;
                ji.offer(k);
            }

        }
        int t = 0;
        for (int i = 0; i < flag.length; i++) {
            if (flag[i]){
                Integer poll = ou.poll();
                t = t *10 + poll;
            }else{
                Integer poll = ji.poll();
                t = t *10 + poll;
            }
        }
        return t;
    }
}
