import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 无重复长度的字符串
 * 给定一个字符串s，请你找出其中不含有重复字符的最长字串的长度
 *
 * @author:syx
 * @date:2021/7/31 14:34
 * @version:v1.0
 */
public class Case3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        //System.out.println(Arrays.toString(chars));
        int result = 0;
        int temp = 0;
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                result = result < temp ? temp : result;
                temp = 0;
                i = map.get(chars[i]);
                map.clear();
            } else {
                temp++;
                map.put(chars[i], i);
            }
        }
        result = result < temp ? temp : result;
        return result;
    }
}
