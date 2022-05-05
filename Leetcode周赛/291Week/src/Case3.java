import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Case3
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/5/1 10:11
 * @Version v0.1
 **/
public class Case3 {
    public static void main(String[] args) {
        System.out.println(countDistinct(new int[]{14,8,8}, 2, 17));
    }
    public static int countDistinct(int[] nums, int k, int p) {
        //presum
        int[] help = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % p == 0) {
                help[i] = 1;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            help[i] = help[i] + help[i - 1];
        }
        //双指针
        Set<String> set = new HashSet<>();

        for (int left = 0; left < nums.length; left++) {
            int right = left;
            while (right < nums.length) {
                int count;
                if (left == 0) {
                    count = help[right];
                } else {
                    count = help[right] - help[left - 1];
                }
                if (count <= k){
                    StringBuffer sb = new StringBuffer();
                    for (int j = left; j <=right ; j++) {
                        sb.append(nums[j]+"-");
                    }
                    set.add(sb.toString());
                    System.out.println(sb.toString());
                };
                right++;
            }
        }
        return set.size();
    }
}
