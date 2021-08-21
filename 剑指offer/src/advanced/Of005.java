package advanced;

import java.util.HashSet;
import java.util.Set;

/**
 * 单词长度的最大乘积
 * @author:syx
 * @date:2021/8/10 9:41
 * @version:v1.0
 */
public class Of005 {
    public static void main(String[] args) {

    }
    public int maxProduct(String[] words) {
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length ; j++) {
                if (!common(words[i],words[j])){
                    result = Math.max(result,words[i].length()*words[j].length());
                }
            }
        }
        return result;
    }
    public static boolean common(String a, String b){
        Set<Character> set = new HashSet<>();
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        for(char s :A){
            set.add(s);
        }
        for (char s:B){
            if (set.contains(s)){
                return true;
            }
        }
        return false;


    }
}
