import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @ClassName Case63
 * @Description 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少
 * @Author SiYiXiong
 * @Date 2022/3/18 16:10
 * @Version v0.1
 **/
public class Case63 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
    public static int maxProfit(int[] prices) {
        if(prices.length<=1){
            return 0;
        }
        //股票的最大利润，就是买出时的股价-买入时的股价
        //数组长度很长，通过遍历基本会超时
        //遍历写的话就是拆分子问题，认为最后一天卖出就是投递股价是最佳，或者不是最后一天卖出投递股价
        //建立help数组，用来标志每一个位置的最小值
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        int[] help = new int[prices.length];//记录在这之前可以买入的最大价格
        help[0] = -1;//第一天之前不可买入
        heap.offer(prices[0]);//放入第一天的价格
        for (int i = 1; i < prices.length; i++) {
            help[i] = heap.peek();
            heap.offer(prices[i]);
        }
        System.out.println(Arrays.toString(help));
        System.out.println(Arrays.toString(prices));
        return Math.max(maxProfit(prices,help,prices.length-1),0);
    }
    public static int maxProfit(int[] prices,int[] help,int right){
        if (right-1<0){return Integer.MIN_VALUE;}
        return Math.max(prices[right]-help[right],maxProfit(prices, help, right-1));

    }
}
