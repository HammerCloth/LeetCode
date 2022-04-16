import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:syx
 * @date:2021/7/31 15:10
 * @version:v1.0
 */
public class Case567 {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "ba"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (map.containsKey(chars1[i])) {
                map.put(chars1[i], map.get(chars1[i]) + 1);
            } else {
                map.put(chars1[i], 1);
            }
        }
        int start = 0;
        int end = 0;
        while (start <= end && end < s2.length()) {
            if (isClear(map)){
                return true;
            }else{
                if (map.containsKey(chars2[end])){
                    map.put(chars2[end],map.get(chars2[end])-1);
                    if (map.get(chars2[end])>=0){
                        end++;
                    }else{
                        while(start<=end&&map.get(chars2[end])<0){
                            map.put(chars2[start],map.get(chars2[start])+1);
                            start++;
                        }
                        end++;
                    }
                }else{
                    while(start<end){
                        map.put(chars2[start],map.get(chars2[start])+1);
                        start++;
                    }
                    start++;
                    end++;
                }
            }
        }
        if (!isClear(map)){
            return false;
        }else{
            return true;
        }
    }

    public static boolean isClear(Map<Character, Integer> map) {
        for (Integer value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;

    }
}
