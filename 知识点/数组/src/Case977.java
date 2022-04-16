import java.util.Arrays;

/**
 * 有序数组的平方
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * @author:syx
 * @date:2021/7/27 9:41
 * @version:v1.0
 */
public class Case977 {
    public static void main(String[] args) {
        int[] nums = new int[]{};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }
    public static int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int[] result = new int[nums.length];
        int k = nums.length - 1;
        while (k >= 0) {
            int aa = nums[left] * nums[left];
            int bb = nums[right] * nums[right];
            if (aa > bb) {
                result[k--] = aa;
                left++;
            } else {
                result[k--] = bb;
                right--;
            }
        }
        return result;
    }
}
