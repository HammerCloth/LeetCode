import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 解码方法(dfs超时了)
 * 一条包含字母 A-Z 的消息通过以下映射进行了编码 ：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要解码已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为 (1 11 06) ，因为 "06" 不能映射为 "F" ，
 * 这是由于 "6" 和 "06" 在映射中并不等价。
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回解码方法的总数 。
 * @author:syx
 * @date: 2021/4/21 8:37
 * @version:v1.0
 */
public class Case91 {
    static int count = 0;
    static final List<String> keyBook = Arrays.asList("1","2","3","4","5","6","7","8","9","10","11",
            "12","14","13","15","16","17","18","19","20","21","22","23","24","25","26");
    static Map<Integer,Integer> dpBook = new HashMap<>();
    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
    }
    public static int numDecodings(String s) {
        dfs(s,0);
        return count;
    }
    public static boolean check(String str){
        return keyBook.contains(str);
    }

    /**
     *
     * @param str
     * @param n
     */
    public static void dfs(String str,int n){
        if (n==str.length()){
            count++;
        }
        for (int i=1;i<=2;i++){
            if (n+i<=str.length()&&check(str.substring(n,n+i))){
                //todo
                dfs(str,n+i);
            }
        }
    }
}

