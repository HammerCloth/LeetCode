package advanced;

import java.util.HashMap;
import java.util.Map;

/**
 * 只出现一次的数字
 * @author:syx
 * @date:2021/8/10 9:33
 * @version:v1.0
 */
public class Of004 {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        for(int i:map.keySet()){
            if (map.get(i)==1){
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }
}
