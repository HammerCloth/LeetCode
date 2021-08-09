import java.util.Arrays;

/**
 * 前 n 个数字二进制中 1 的个数
 *
 * @author:syx
 * @date:2021/8/9 11:13
 * @version:v1.0
 */
public class Of003 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }

    public static int[] countBits(int n) {
        int[] resultA = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int result = 0;
            int key = i;
            while (key > 0) {
                key = key & (key - 1);
                result++;
            }
            resultA[i] = result;
        }
        return resultA;
    }
}
