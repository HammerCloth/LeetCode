package advanced;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:syx
 * @date:2021/8/19 9:16
 * @version:v1.0
 */
public class Of012 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));
    }
    public static int pivotIndex(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int prenum = 0;
        for (int i = 0; i < nums.length; i++) {
            prenum+=nums[i];
            int save = 2*prenum-nums[i];
            if (!map.containsKey(save)){
                map.put(save,i);
            }
        }
        if (map.containsKey(prenum)){
            return map.get(prenum);
        }else{
            return -1;
        }
    }
}
