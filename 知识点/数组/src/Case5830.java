/**三除数
 * 给你一个整数 n 。如果 n 恰好有三个正除数 ，返回 true ；否则，返回 false 。
 * 如果存在整数 k ，满足 n = k * m ，那么整数 m 就是 n 的一个 除数 。
 * @author:syx
 * @date:2021/8/1 10:32
 * @version:v1.0
 */
public class Case5830 {
    public static void main(String[] args) {
        for (int i = 1; i <82 ; i++) {
            System.out.println(i+"\t"+isThree(i));
        }
    }
    public static boolean isThree(int n) {
        if (n==1){
            return false;
        }
        int result = 0;
        for (int i=2;i<n/2+1;i++){
            if (n%i==0){
                result++;
            }
            if (result>1){
                return false;
            }
        }
        if (result==1){
            return true;
        }else{
            return false;
        }

    }
}
