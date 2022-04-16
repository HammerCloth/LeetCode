package advanced;

import java.util.HashMap;
import java.util.Map;

/**0和1个数相同的子数组
 * @author:syx
 * @date: 2021/8/18 20:13
 * @version:v1.0
 */
public class Of011 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1};
        System.out.println(findMaxLength(nums));
        System.out.println(findMaxLength2(nums));

    }
    public static int findMaxLength(int[] nums) {
        int length=0;
        //所有的元素相加起来是长度的一半就是符合条件的。
        //子数组务必是偶数个
        for(int left=0;left<nums.length;left++){
            int sum = 0;
            for (int right = left+1; right < nums.length; right+=2) {
                sum+=nums[right-1];
                sum+=nums[right];
                if (sum*2==(right-left+1)){
                    length = Math.max(right-left+1,length);
                }
            }
        }
        return length;
    }
    public static int findMaxLength2(int[] nums) {
        int length=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0){
                preSum+=(-1);
            }else{
                preSum++;
            }
            if (map.containsKey(preSum)){
                Integer k = map.get(preSum);
                length = Math.max(length,i-k);
            }
            if (!map.containsKey(preSum)){
                map.put(preSum,i);
            }

        }
        return length;
    }

}
