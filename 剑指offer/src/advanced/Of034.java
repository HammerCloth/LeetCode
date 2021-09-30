package advanced;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:syx
 * @date: 2021/9/8 9:34
 * @version:v1.0
 */
public class Of034 {
    public static void main(String[] args) {

    }
    public static boolean isAlienSorted(String[] words, String order) {
        //建立对比用的map
        char[] chars = order.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i],i);
        }

        //开始逐个对比
        int left = 0;
        int right = 1;
        while(right<words.length){
            if (compare(words[left],words[right],map)){
                left++;
                right++;
            }else{
                return false;
            }
        }
        return true;


    }

    public static boolean compare(String a,String b,Map<Character,Integer> map){
        int size = Math.min(a.length(),b.length());
        for (int i = 0; i < size; i++) {
            if (a.charAt(i)!=b.charAt(i)){
                if (map.get(a.charAt(i))==map.get(b.charAt(i))){

                }else if (map.get(a.charAt(i))>map.get(b.charAt(i))){
                    return false;
                }else if (map.get(a.charAt(i))<map.get(b.charAt(i))){
                    return true;
                }
            }
        }
        if (a.length()>b.length()){
            return false;
        }
        return true;
    }
}
