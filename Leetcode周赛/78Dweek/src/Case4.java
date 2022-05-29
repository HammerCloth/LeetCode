import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName Case4
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/5/15 10:32
 * @Version v0.1
 **/
public class Case4 {
    public boolean digitCount(String num) {
        char[] chars = num.toCharArray();
        int[] nums = new int[chars.length];
        int[] help = new int[chars.length];//用于记录次数
        for (int i = 0; i < chars.length; i++) {
            nums[i] = chars[i]-'0';
            help[nums[i]]++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (nums[i]!=help[i]) return false;
        }
        return true;
    }
}
