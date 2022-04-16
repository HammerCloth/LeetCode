package advanced;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:syx
 * @date:2021/9/16 9:50
 * @version:v1.0
 */
public class Of041 {
    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(5));
    }

}
class MovingAverage {
    private static int size;
    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        this.queue = new LinkedList<>();
    }

    public double next(int val) {
        if (queue.size()<size){
            queue.offer(val);
        }else{
            queue.poll();
            queue.offer(val);
        }
        return ave(queue);
    }

    public static double ave(Queue<Integer> queue){
        double result=0;
        for(Integer i:queue){
            result+=i;
        }
        return result/queue.size();
    }
}