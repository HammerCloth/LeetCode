package advanced;

import java.util.*;

/**
 * @author:syx
 * @date:2021/9/7 9:26
 * @version:v1.0
 */
public class Of033 {
    public static void main(String[] args) {
        String[] strs = new String[]{"a"};
        groupAnagrams(strs).forEach(System.out::println);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            if (map.containsKey(s)){
                map.get(s).add(str);
            }else{
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(s,list);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (String key:map.keySet()){
            result.add(map.get(key));
        }
        return result;
    }

}
