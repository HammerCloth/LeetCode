package advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 字符串中的所有变位词,通过转化成数组匹配的滑动窗口
 * @author:syx
 * @date: 2021/8/22 9:15
 * @version:v1.0
 */
public class Of015 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result= new ArrayList<>();
        if (p.length()>s.length()){
            return result;
        }
        int[] partten = new int[26];
        int[] temp = new int[26];
        char[] chars1 = p.toCharArray();
        char[] chars2 = s.toCharArray();
        for (int i = 0; i < p.length(); i++) {
            partten[(int)chars1[i]-97]=partten[(int)chars1[i]-97]+1;
        }
        int len = p.length();
        int left = 0;
        int right = 0;
        for (; right < len; right++) {
            temp[(int)chars2[right]-97]=temp[(int)chars2[right]-97]+1;
        }
        if (Arrays.equals(temp,partten)){
            result.add(left);
        }
        for (;right<chars2.length;right++){
            temp[(int)chars2[left]-97] = temp[(int)chars2[left]-97]-1;
            left++;
            temp[(int)chars2[right]-97] = temp[(int)chars2[right]-97]+1;
            if (Arrays.equals(temp,partten)){
                result.add(left);
            }
        }
//        while(!Arrays.equals(partten,temp)&&left<chars2.length&&right< chars2.length){
//            temp[(int)chars2[left]-97] = temp[(int)chars2[left]-97]-1;
//            temp[(int)chars2[right]-97] = temp[(int)chars2[right]-97]+1;
//            left++;
//            right++;
//        }
        return result;
    }
}
