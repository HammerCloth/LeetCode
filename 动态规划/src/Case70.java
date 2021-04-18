import java.util.Arrays;

/**爬楼梯
 * 假设你正在爬楼梯。需要n阶你才能到达楼顶
 * 每次你可以爬1或者2个台阶。你有多少种不同的方法可以爬到楼顶呢
 * @author:syx
 * @date:2021/4/18 19:07
 * @version:v1.0
 */
public class Case70 {

    public static void main(String[] args) {

        System.out.println(climbStairs(3));
    }
    public static int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        //利用空间换时间的解法，使用数组来记录每次得到的结果，然后逐步求解，算是递归的正向解法
        int[] dp = new int[n+1];
        dp[2]=2;
        dp[1]=1;
        for (int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];

    }

}
