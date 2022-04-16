package advanced;

import java.util.Arrays;

/** 字符串中的变位词
 * @author:syx
 * @date: 2021/8/21 9:53
 * @version:v1.0
 */
public class Of014 {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "esbaooo";
        System.out.println(checkInclusion(s1, s2));
    }
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length()>s2.length()){
            return false;
        }
        int[] partten = new int[26];
        int[] temp = new int[26];
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        for (int i = 0; i < s1.length(); i++) {
            partten[(int)chars1[i]-97]=partten[(int)chars1[i]-97]+1;
        }
        int len = s1.length();
        int left = 0;
        int right = 0;
        for (; right < len; right++) {
            temp[(int)chars2[right]-97]=temp[(int)chars2[right]-97]+1;
        }
        while(!Arrays.equals(partten,temp)&&left<chars2.length&&right< chars2.length){
            temp[(int)chars2[left]-97] = temp[(int)chars2[left]-97]-1;
            temp[(int)chars2[right]-97] = temp[(int)chars2[right]-97]+1;
            left++;
            right++;
        }

        return Arrays.equals(partten,temp);
    }


}
