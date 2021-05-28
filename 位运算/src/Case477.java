/**
 * 汉明距离总和
 * 两个整数的汉明距离指的是这两个数字的二进制数对应位不同的数量。
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 *
 * @author:syx
 * @date: 2021/5/28 20:59
 * @version:v1.0
 */
public class Case477 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,14,2};
        System.out.println(totalHammingDistance(nums));
    }

    public static int HammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static int totalHammingDistance(int[] nums) {
        int result=0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                result += Integer.bitCount(nums[i] ^ nums[j]);
            }
        }
        return result;
    }

    /**
     *这里就是在使用按照位的运算来节省时间，
     *貌似位运算的题目，按照位数来循环是一个不错的思路
     * @param nums
     * @return
     */
    public int totalHammingDistance2(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < 30; ++i) {
            int c = 0;
            for (int val : nums) {
                c += (val >> i) & 1;
            }
            ans += c * (n - c);
        }
        return ans;
    }
}
