import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Case4
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/5/1 11:45
 * @Version v0.1
 **/
public class Case4 {
    public static void main(String[] args) {
         System.out.println(appealSum(" "));
    }
    public static long appealSum(String s) {
        char[] chars = s.toCharArray();
        Long count = 0L;
        for (int left = 0; left < chars.length; left++) {
            Set<Character> set = new HashSet<>();
            for (int right = left; right < chars.length; right++) {
                set.add(chars[right]);
                count+=set.size();
            }
        }
        return count;
    }
}
