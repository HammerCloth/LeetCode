import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName Case
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/7 19:31
 * @Version v0.1
 **/
public class Case {
    public static void main(String[] args) {
        System.out.println(minCnt("100"));
        System.out.println(minCnt("01"));
        System.out.println(minCnt("01001"));

    }
    public static int minCnt (String s) {
        char[] chars = s.toCharArray();
        boolean flag = true;
        int count0 = 0;
        int count1 = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='1'){
                flag = false;
            }
            if (flag&&chars[i]=='0'){
                count0++;
            }
            if (!flag&&chars[i]=='1'){
                count1++;
            }
        }
        return count0+count1;
    }
}
