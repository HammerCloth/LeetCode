/**
 * @ClassName Case1
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/16 21:58
 * @Version v0.1
 **/
public class Case1 {
    public int findClosestNumber(int[] nums) {
        int  value = Integer.MAX_VALUE;//到0的绝对值
        int key = Integer.MIN_VALUE;//值本身要求最大
        for (int i = 0; i < nums.length; i++) {
            int abs = Math.abs(nums[i]);
            if (abs==value){
                key = Math.max(key,nums[i]);
            }
            if (abs<value){
                value = abs;
                key = nums[i];
            }
        }
        return key;
    }
}
