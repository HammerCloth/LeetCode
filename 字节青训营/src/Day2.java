/**
 * @ClassName Day2
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/11 16:07
 * @Version v0.1
 **/
public class Day2 {
    public static void main(String[] args) {
        System.out.println(countK(new int[]{1, 2, 3, 4}, 4));
    }

    //给定一个正整数数组 arrs 和整数 K ，请找出该数组内乘积小于等于 k 的连续的子数组的个数，算法时间复杂度o(n)。
    public static int countK(int[] arrs, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        int mut = 1;
        while (left <= right && right < arrs.length) {
            mut = mut * arrs[right];
            if (mut <= k) {
                count++;
                System.out.println(left + " " + right);
                right++;
            } else {
                left++;
                right = left;
                mut = 1;
            }
        }
        return count;
    }
}
