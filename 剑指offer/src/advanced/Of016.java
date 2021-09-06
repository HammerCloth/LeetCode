package advanced;

import java.util.HashMap;
import java.util.Map;

/**
 * 不含重复字符的最长子字符串
 *
 * @author:syx
 * @date: 2021/8/24 9:50
 * @version:v1.0
 */
public class Of016 {
    public static void main(String[] args) {
        String s = "";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> help = new HashMap<>();
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        for (; right < chars.length; right++) {
            char k =chars[right];
            if (help.containsKey(k)){
                maxLen = Math.max(maxLen,right-left);
                int newLeft = help.get(k);
                for (; left <=newLeft ; left++) {
                    help.remove(chars[left]);
                }
                help.put(k,right);
            }else{
                maxLen = Math.max(maxLen,right-left+1);
                help.put(k,right);
            }
        }
        return maxLen;
    }
}
