package advanced;

import java.util.HashMap;
import java.util.Map;

/**回文子字符串的个数
 * @author:syx
 * @date: 2021/8/28 10:27
 * @version:v1.0
 */
public class Of020 {
    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
    }
    public static int countSubstrings(String s) {
        int count = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int left = 0; left < s.length(); left++) {
            for (int right = left; right < s.length(); right++) {
                char temp = s.charAt(right);
                count = isRev(s,left,right)?count+1:count;
            }
        }
        return count;
    }
    public static boolean isRev(String s,int left,int right){
        if (left==right){
            return true;
        }
        while(left<right){
            if (s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
}
