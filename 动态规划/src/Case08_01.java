/**
 * 三步问题
 * 三步问题。有一个小孩上楼梯，楼梯上有n阶台阶，小孩一次可以上1阶，2阶或者3阶。
 * 实现一种方法，计算小孩有多少种上楼梯的方式
 * @author:syx
 * @date: 2021/6/9 11:51
 * @version:v1.0
 */
public class Case08_01 {
    public static void main(String[] args) {
        System.out.println(waysToStep2(76));
    }
    public static int waysToStep(int n) {
        if (n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if (n==3){
            return 4;
        }
        return (waysToStep(n-1)+waysToStep(n-2)+waysToStep(n-3))%1000000007;
    }
    public static int waysToStep2(int n) {
        if (n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if (n==3){
            return 4;
        }
        long[] help = new long[n+1];
        help[1]=1;
        help[2]=2;
        help[3]=4;
        for (int i=4 ;i<=n;i++){
            help[i]=help[i-1]%1000000007+help[i-2]%1000000007+help[i-3]%1000000007;
        }
        return (int)(help[n]%1000000007);
    }

}
