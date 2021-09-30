/**
 * 两整数之和
 *
 * @author:syx
 * @date:2021/9/26 9:18
 * @version:v1.0
 */
public class Case371 {
    public static void main(String[] args) {

        System.out.println(getSum(1, 2));
    }

    public static int getSum(int a, int b) {

        while (b != 0) {
            int help = (a & b) << 1;
            a = a ^ b;
            b = help;
        }
        return a;

    }


}
