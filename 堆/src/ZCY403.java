import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入：
 * 参数一：正整数数组costs
 * 参数二：正整数数组profits
 * 参数三：正数k
 * 参数四：正数m
 * costs[i]表示i号项目的花费
 * profits[i]表示i号项目在扣除花费之后还能挣到钱
 * k表示你不能并行，只能串行是最多做k个项目
 * m表示你初始的资金
 * <p>
 * 说明：你每次做完一个项目，马上获得的收益，可以支持你去做下一个项目
 * <p>
 * 输出：你最后获得的最大钱数
 *
 * @author:syx
 * @date: 2021/6/18 16:17
 * @version:v1.0
 */
public class ZCY403 {
    public static void main(String[] args) {
        int[] costs = {1,2,3};
        int[] profits = {3,4,2};
        System.out.println(greatProfit(profits,costs,2,2));
    }
    /**
     * 通过使用两个堆来计算最后获得的最大钱数，主要使用的是贪心算法。每次做目前项目中可以获得最大收益的
     * 项目就可以直接得到最大的收益。
     *
     * @param profits profits[i]表示i号项目在扣除花费之后还能挣到钱
     * @param costs   costs[i]表示i号项目的花费
     * @param k       k表示你不能并行，只能串行是最多做k个项目
     * @param m       m表示你初始的资金
     * @return 你最后获得的最大钱数
     */
    public static int greatProfit(int[] profits, int[] costs, int k, int m) {
        PriorityQueue<Project> costHeap = new PriorityQueue<>(new CostComparator());
        PriorityQueue<Project> profitsHeap = new PriorityQueue<>(new ProfitComparator());

        for (int i = 0; i < costs.length; i++) {
            costHeap.add(new Project(costs[i], profits[i]));
        }

        int result = m;
        for (int i=1;i<=k;i++){
             while(!costHeap.isEmpty()&&costHeap.peek().getCost()<=result){
                profitsHeap.add(costHeap.poll());
            }
            result = profitsHeap.peek().getProfit()+result;
        }
        return result;
    }

    public static class CostComparator implements Comparator<Project> {
        @Override
        public int compare(Project o1, Project o2) {
            return o1.getCost() - o2.getCost();
        }
    }

    public static class ProfitComparator implements Comparator<Project> {
        @Override
        public int compare(Project o1, Project o2) {
            return o2.getProfit() - o1.getProfit();
        }
    }

    public static class Project {
        private int cost;
        private int profit;

        public Project(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }

        public Project() {
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public int getProfit() {
            return profit;
        }

        public void setProfit(int profit) {
            this.profit = profit;
        }
    }
}
