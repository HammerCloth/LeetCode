/**
 * 汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * @author:syx
 * @date: 2021/5/27 8:46
 * @version:v1.0
 */
public class Case461 {
    public static void main(String[] args) {
        int i = hammingDistance2(1, 4);
        System.out.println(i);
    }
    public static int hammingDistance(int x, int y) {
        int z = x ^ y;
        String str = Integer.toBinaryString(z);
        int count =0 ;
        for (int i=0;i<str.length();i++){
            char temp = str.charAt(i);
            if(temp=='1'){
                count++;
            }
        }
        return count;
    }
    public static int hammingDistance2(int x, int y) {
        return Integer.bitCount(x^y);
    }
}
