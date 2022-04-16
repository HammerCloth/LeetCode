import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其
 * 余每个元素均出现两次。找出那个只出现了一次的元素。
 * @author:syx
 * @date: 2021/8/8 13:30
 * @version:v1.0
 */
public class Case136 {

    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                map.put(nums[i],2);
            }else{
                map.put(nums[i],1);
            }
        }
        for (int i:map.keySet()){
            if (map.get(i)==1){
                return i;
            }
        }
        return -1;
    }
    public int singleNumber2(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

}
