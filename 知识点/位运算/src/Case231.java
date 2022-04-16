/**
 * @author:syx
 * @date: 2021/8/7 9:36
 * @version:v1.0
 */
public class Case231 {
    public static void main(String[] args) {

        System.out.println(isPowerOfTwo(16));
    }
    public static boolean isPowerOfTwo(int n) {
        String s = Integer.toBinaryString(n);
        int nums = s.length();
        int key = (int)Math.pow(2,nums-1);
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(key));
        return (key ^ n) == 0;
    }
}
