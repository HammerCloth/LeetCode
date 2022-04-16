/**
 * 打家劫舍
 *
 * @author:syx
 * @date: 2021/8/6 10:30
 * @version:v1.0
 */
public class Case198 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(rob2(nums));
    }

    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return rob(nums, 0);
    }

    public static int rob(int[] nums, int left) {
        if (left == nums.length - 1) {
            return nums[nums.length - 1];
        }
        if (left > nums.length - 1) {
            return 0;
        }
        int rob = rob(nums, left + 2);
        int rob2 = rob(nums, left + 1);
        return Math.max(rob + nums[left], rob2);
    }

    public static int rob2(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int a = 0;
        int b = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            int help = Math.max(a + nums[i], b);
            a = b;
            b = help;
        }
        return b;
    }

}
