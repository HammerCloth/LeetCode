import java.util.Arrays;

/**
 * 解码异或后的数组
 * 未知整数数组 arr 由 n 个非负整数组成。
 * 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
 * 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
 * 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
 * <p>
 * 公式推导
 * a^b=c
 * b^a=a^b=c
 * b^a^a=b^0=b
 * c^a=b
 *
 * @author:syx
 * @date: 2021/5/6 19:08
 * @version:v1.0
 */
public class Case1720 {
    public static void main(String[] args){
        int[] encoded = new int[]{1,2,3};
        int first = 1;
        System.out.println(Arrays.toString(decode(encoded,first)));
    }
    public static int[] decode(int[] encoded, int first) {
        int[] result = new int[encoded.length + 1];
        result[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            result[i + 1] = result[i] ^ encoded[i];
        }
        return result;
    }
}
