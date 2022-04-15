import java.math.BigInteger;
import java.util.PriorityQueue;

/**
 * @ClassName Case3
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/10 11:28
 * @Version v0.1
 **/
public class Case3 {
    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[]{24, 5, 64, 53, 26, 38}, 54));
    }
    public static int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            heap.offer(nums[i]);
        }
        for (int i = 0; i < k; i++) {
            Integer poll = heap.poll();
            heap.offer(++poll);
        }
        BigInteger t = new BigInteger(heap.poll().toString());
        while(!heap.isEmpty()){
            Integer temp = heap.poll();
            BigInteger b = new BigInteger(temp.toString());
            t = t.multiply(b);
        }
        BigInteger[] bigIntegers = t.divideAndRemainder(new BigInteger("1000000007"));
        return bigIntegers[1].intValue();
    }
}
