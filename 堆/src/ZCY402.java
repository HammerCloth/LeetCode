import java.util.PriorityQueue;

/**
 * 一块金条切成两半，是需要花费和长度数值一样的铜板，比如长度为20的
 * 金条，不管切成长度多大的两半，都要花费20个铜板。一群人想整分整块
 * 金条，怎么分最省铜板。
 * @author:syx
 * @date: 2021/6/16 16:17
 * @version:v1.0
 */
public class ZCY402 {
    public static void main(String[] args) {
        int[] nums = new int[]{10,20,30};
        System.out.println(gPartiton(nums));
    }
    public static int gPartiton(int[] nums){
        int result = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for (int i:nums){
            heap.add(i);
        }
        while(heap.size()>1){
            int a = heap.poll();
            int b = heap.poll();
            int c = a+b;
            result+=c;
            heap.add(c);
        }
        return result;
    }
}
