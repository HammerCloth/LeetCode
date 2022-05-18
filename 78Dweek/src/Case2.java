import java.util.Arrays;

/**
 * @ClassName Case2
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/5/14 22:24
 * @Version v0.1
 **/
public class Case2 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,0};
        System.out.println(waysToSplitArray(nums));
    }
    public static int waysToSplitArray(int[] nums) {
        int count = 0;
        long[] pre = new long[nums.length];
        pre[0] = nums[0];
        for (int i = 1; i <nums.length ; i++) {
            pre[i] = nums[i]+pre[i-1];
        }
        System.out.println(Arrays.toString(pre));
        for (int i = 0; i < nums.length-1; i++) {
            long a = pre[i];
            long b = pre[pre.length-1]-pre[i];
            if (a>=b) count++;
        }
        return count;
    }
}

