/**
 * @ClassName Case2
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/2 23:28
 * @Version v0.1
 **/
public class Case2 {
    public static void main(String[] args) {
        minBitFlips(3,4);
    }
    public static int minBitFlips(int start, int goal) {
        int i = start ^ goal;
        System.out.println(Integer.bitCount(i));
        return Integer.bitCount(i);
    }
}
