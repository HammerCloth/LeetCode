/**
 * 拿硬币
 * 桌上有n堆硬币，每堆的数量保存在数组中coins中。我们可以任意选择一堆，拿走其中的一枚或者两枚
 * 求拿完所有硬币的最少次数。
 *
 * @author:syx
 * @date: 2021/6/10 16:33
 * @version:v1.0
 */
public class LCP06 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,10};
        System.out.println(minCount(nums));
    }
    public static int minCount(int[] coins) {
        int count = 0;
        for (int i : coins) {
            int times = i / 2;
            if (i % 2 == 0) {
                count += times;
            } else {
                count += (times + 1);
            }
        }
        return count;
    }
}
