/**
 * @ClassName Case713
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/5/5 17:34
 * @Version v0.1
 **/
public class Case713 {
    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        for (int left = 0; left < nums.length; left++) {
            int sum = 1;
            for (int right = left; right <nums.length; right++) {
                sum = sum*nums[right];
                if (sum<k) count++;
                else break;
            }
        }
        return count;
    }
}
