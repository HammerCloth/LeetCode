/**
 * 数组异或操作
 *
 * 给你两个整数，n 和 start 。
 * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 *
 * @author:syx
 * @date: 2021/5/7 10:20
 * @version:v1.0
 */
public class Case1486 {
    public static void main(String[] args) {
        System.out.println(xorOperation(5,0));
    }
    public static int xorOperation(int n, int start) {
        int result = start;//i=0
        for(int i=1;i<n;i++){
            result = result^(start+2*i);
        }
        return result;
    }
}
