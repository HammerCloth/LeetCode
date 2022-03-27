import java.io.BufferedInputStream;
import java.util.*;

/**
 * @ClassName Case2
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/3/22 19:54
 * @Version v0.1
 **/
public class Case2 {
    static HashMap<String, String> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        char[] chars = sc.nextLine().toCharArray();
        int[] help1 = new int[chars.length];//当前含有多少1
        int[] help0 = new int[chars.length]; //当前含有多少0
        if (chars[0] == '1') {
            help1[0] = 1;
            help0[0] = 0;
        } else {
            help1[0] = 0;
            help0[0] = 1;
        }
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '1') {
                help1[i] = help1[i - 1] + 1;
                help0[i] = help0[i - 1];
            } else {
                help1[i] = help1[i - 1];
                help0[i] = help0[i - 1] + 1;
            }
        }
        for (int i = chars.length - 1; i >= 1; i--) {
            int right = i - 1;
            int left = 0;
            while (right < chars.length) {
                int num_1 = getnum(right, left, help1);
                int num_0 = getnum(right, left, help0);
                String key = num_0 + "-" + num_1;
//                System.out.print(key+" ");
                String value = (left + 1) + " " + (right + 1);
//                System.out.println(value);
                if (map.containsKey(key)) {
                    //发现重复
                    System.out.println(map.get(key) + " " + value);
                    return;
                } else {
                    map.put(key, value);
                }
                right++;
                left++;
            }
        }
    }

    public static int getnum(int right, int left, int[] help) {
              String sss = new String("sddf");
        if (left == 0) {
            return help[right];
        } else {
            return help[right] - help[left - 1];
        }
    }
}
