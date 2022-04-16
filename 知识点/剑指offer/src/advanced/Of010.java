package advanced;

/**和为k的子数组
 * @author:syx
 * @date:2021/8/18 19:54
 * @version:v1.0
 */
public class Of010 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        int k = 3;
        System.out.println(subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int left= 0;left<nums.length;left++){
            int sum = 0;
            for (int right=left;right<nums.length;right++){
                sum+=nums[right];
                if (sum==k){
                    count++;
                }
            }
        }
        return count;
    }
}
