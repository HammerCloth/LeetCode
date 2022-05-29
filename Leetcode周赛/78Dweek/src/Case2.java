import java.util.Arrays;
import java.util.HashMap;

/**
 * @ClassName Case2
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/5/14 22:24
 * @Version v0.1
 **/
public class Case2 {
    public String largestWordCount(String[] messages, String[] senders) {
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < messages.length; i++) {
            int len = messages[i].split(" ").length;
            if (map.containsKey(senders[i])){
                map.put(senders[i],map.get(senders[i])+len);
            }else {
                map.put(senders[i], len);
            }
        }
        int count = 0;
        String result="zzzzzzzzz";
        for(String key :map.keySet()){
            int len = map.get(key);
            if (count<len){
                count = len;
                result = key;
            } else if (count==len) {
                //比较字典序号
                if (result.compareTo(key)<0){//result<key
                    result = key;
                }
            }
        }
        return result;
    }

}

