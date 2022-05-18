import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Case933
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/5/6 08:25
 * @Version v0.1
 **/
public class RecentCounter {
    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.offer(t);
        while(t-queue.peek()>3000){
            queue.poll();
        }
        return queue.size();
    }
}
