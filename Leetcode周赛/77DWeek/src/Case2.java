/**
 * @ClassName Case2
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/30 22:18
 * @Version v0.1
 **/
public class Case2 {
    public static void main(String[] args) {
        int[] ints = {2, 5, 3, 9, 5, 3};
        //int[] ints = {0};
        System.out.println(minimumAverageDifference(ints));
    }
    //

    public static int minimumAverageDifference(int[] nums) {
        Long[] preSum = new Long[nums.length];
        preSum[0] = Long.valueOf(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = nums[i] + preSum[i - 1];
        }
        Long count = Long.valueOf(Integer.MAX_VALUE);
        int result = -1;
        for (int i = 0; i < nums.length; i++) {//遍历每一个坐标
            Long x = (preSum[i] / (i + 1));
            Long y;
            if (nums.length - i - 1 == 0) {
                y = Long.valueOf(0);
            } else {
                y = (preSum[nums.length - 1] - preSum[i] )/ (nums.length - i - 1);
            }
            Long abs = Math.abs(x - y);

            if (count > abs) {
                count = abs;
                result = i;
            }
        }
        return result;
    }
}
