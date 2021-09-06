package advanced;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**含有所有字符的最短字符串
 * @author:syx
 * @date: 2021/8/25 9:59
 * @version:v1.0
 */
public class Of017 {
    public static void main(String[] args) {
        String s = "A";
        String t = "aa";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        String result = "";
        ArrayList<Character> node = new ArrayList<>();
        ArrayList<Integer> index = new ArrayList<>();
        Map<Character,Integer> partten = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (partten.containsKey(c)){
                partten.put(c,partten.get(c)+1);
            }else{
                partten.put(c,1);
            }
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (partten.containsKey(chars[i])){
                node.add(chars[i]);
                index.add(i);
            }
        }
        Map<Character,Integer> temp = new HashMap<>();
        temp.putAll(partten);
        int left=0;
        for (int right = 0; right < node.size();) {
            if (temp.containsKey(node.get(right))&&temp.get(node.get(right))>1){
                temp.put(node.get(right),temp.get(node.get(right))-1);
            }else if(temp.containsKey(node.get(right))&&temp.get(node.get(right))==1){
                temp.remove(node.get(right));
            }
            if (temp.isEmpty()){
                temp.putAll(partten);
                String Aresult =  s.substring(index.get(left),index.get(right)+1);
                left++;
                right=left;
                if (result.length()==0){
                    result=Aresult;
                }else{
                    result=result.length()>Aresult.length()?Aresult:result;
                }
            }else{
                right++;
            }

        }
        return result;
    }
}
