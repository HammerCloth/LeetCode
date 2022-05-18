import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName Case4
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/5/15 10:32
 * @Version v0.1
 **/
public class Case4 {
    public static void main(String[] args) {
        String[] strings = {"abba", "baba", "bbaa", "cd", "cd"};
        removeAnagrams(strings);
    }

    public static List<String> removeAnagrams(String[] words) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            list.add(words[i]);
        }
        int key = 0;
        while (key + 1 < list.size()) {

            boolean check = check(list.get(key), list.get(key + 1));
            if (check) list.remove(key + 1);
            else key++;

        }
        return list;
    }

    public static boolean check(String a, String b) {
        if (a.length() != b.length()) return false;//不是
        int[] help = new int[26];
        char[] A = a.toCharArray();
        for (int i = 0; i < A.length; i++) {
            help[A[i] - 'a']++;
        }
        char[] B = b.toCharArray();
        for (int i = 0; i < B.length; i++) {
            help[B[i] - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (help[i] != 0) return false;
        }
        return true;
    }
}
