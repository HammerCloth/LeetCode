import java.util.ArrayList;
import java.util.List;

/**
 * 字母大小写全排列
 *
 * @author:syx
 * @date: 2021/8/5 15:52
 * @version:v1.0
 */
public class Case784 {
    public static void main(String[] args) {
        letterCasePermutation("a1b2").forEach(System.out::println);
    }

    public static List<String> letterCasePermutation(String s) {
        char[] chars = s.toCharArray();
        return letterCasePermutation(chars, 0);
    }

    public static List<String> letterCasePermutation(char[] s, int left) {
        List<String> result = new ArrayList<>();
        if (left > s.length - 1) {
            result.add("");
            return result;
        }
        List<String> strings = letterCasePermutation(s, left + 1);
        if (s[left] >= 97 && s[left] <= 122) {
            //a-z
            strings.forEach((str) -> {
                result.add(s[left] + str);
                result.add((char) (s[left] - 32) + str);
            });
        } else if (s[left] >= 65 && s[left] <= 90) {
            //A-Z
            strings.forEach((str) -> {
                result.add(s[left] + str);
                result.add((char) (s[left] + 32) + str);
            });
        } else {
            //0-9
            strings.forEach((str) -> {
                result.add(s[left] + str);
            });
        }
        return result;
    }
}
