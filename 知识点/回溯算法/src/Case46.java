import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 全排列
 *
 * @author:syx
 * @date: 2021/8/5 11:58
 * @version:v1.0
 */
public class Case46 {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(permute(nums));
    }
    public static List<List<Integer>> permute(int[] nums) {
        if (nums.length==0){
            return null;
        }
        List<List<Integer>> permute = permute(nums, 0);
        return permute;
    }

    public static List<List<Integer>> permute(int[] nums, int left) {
        List<List<Integer>> result = new ArrayList<>();
        if (left==nums.length-1){
            List<Integer> x = new ArrayList<>();
            x.add(nums[nums.length-1]);
            result.add(x);
            return result;
        }
        List<List<Integer>> temp = permute(nums, left + 1);
        temp.forEach((o)->{
            int size = o.size();
            for(int i=0;i<size;i++){
                List<Integer> dest = new ArrayList<>();
                for (int j=0;j<o.size();j++){
                    dest.add(o.get(j));
                }
                dest.add(i,nums[left]);
                result.add(dest);
            }
            List<Integer> dest = new ArrayList<>();
            for (int j=0;j<o.size();j++){
                dest.add(o.get(j));
            }
            dest.add(nums[left]);
            result.add(dest);
        });
        return result;
    }
}
