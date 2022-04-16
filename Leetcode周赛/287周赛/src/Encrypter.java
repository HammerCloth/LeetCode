import java.util.*;

/**
 * @ClassName Case4
 * @Description
 *
 * ["Encrypter","decrypt","decrypt","decrypt","decrypt","decrypt","decrypt"]
 * [,["aaaa"],["aa"],["aaaa"],["aaaaaaaa"],["aaaaaaaaaaaaaa"],["aefagafvabfgshdthn"]]
 * @Author SiYiXiong
 * @Date 2022/4/3 11:07
 * @Version v0.1
 **/
public class Encrypter {
    public static void main(String[] args) {
        Encrypter e = new Encrypter(new char[]{'a', 'b', 'c', 'd'}, new String[]{"aa", "bb", "cc", "zz"}, new String[]{"aa", "aaa", "aaaa", "aaaaa", "aaaaaaa"});
        e.decrypt("aefagafvabfgshdthn");
    }
    public char[] keys;
    public String[] values;
    public String[] dictionary;
    public HashMap<Character,Integer> keysMap;
    public HashMap<String, List<Integer>> valusMap;
    public Set<String> set;
    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        this.keys = keys;
        this.values = values;
        this.dictionary = dictionary;
        this.keysMap = new HashMap<>();
        this.valusMap = new HashMap<>();
        this.set = new HashSet<>();
        for (int i = 0; i < keys.length; i++) {
            keysMap.put(keys[i],i);
        }
        for (int i = 0;i<values.length;i++){
            if (valusMap.containsKey(values[i])){
                List<Integer> list = valusMap.get(values[i]);
                list.add(i);
                valusMap.put(values[i],list );
            }else{
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                valusMap.put(values[i],temp);
            }
        }
        for (int i = 0; i < dictionary.length; i++) {
            set.add(dictionary[i]);
        }
    }

    public String encrypt(String word1) {
        StringBuffer sb = new StringBuffer();
        for (char c : word1.toCharArray()) {
            int index = keysMap.get(c);
            sb.append(values[index]);
        }
        return sb.toString();
    }

    public int decrypt(String word2) {
        List<List<Integer>> temp = new ArrayList<>();
        for (int i = 0; i < word2.length(); i+=2) {
            String substring = word2.substring(i, i + 2);
            if (valusMap.get(substring)==null){
                return 0;
            }
            temp.add(valusMap.get(substring));
        }
        return bfs(temp,0,new StringBuffer());
    }
    public int bfs(List<List<Integer>> temp,int index,StringBuffer sb){
        if (index==temp.size()){
            String s = sb.toString();
            if (set.contains(s)){
                System.out.println(s);
                return 1;
            }
            return 0;
        }
        int result = 0;
        List<Integer> list = temp.get(index);
        for (int i:list){
            sb.append(keys[i]);
            result+=bfs(temp,index+1,sb);
            sb.delete(sb.length()-1, sb.length());
        }
        return result;
    }
}
