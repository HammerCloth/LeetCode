package src;

import java.util.*;

/**
 * @ClassName Case4
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/5/8 12:20
 * @Version v0.1
 **/
public class Case4 {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(nums[num]<0){
                list.add(num);
            }else{
                nums[num] = -nums[num];
            }
        }
        return list;
    }

}
