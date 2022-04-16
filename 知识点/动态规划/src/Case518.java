/**
 * 零钱兑换
 * 给定不同面额的硬币和一个总金额，
 * 写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无数个
 *
 * @author:syx
 * @date: 2021/6/10 16:44
 * @version:v1.0
 */
public class Case518 {

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2,5};
        System.out.println(change2(5, coins));
    }

    public static int change(int amount, int[] coins) {
        if (coins == null) {
            return 0;
        }
        if (coins.length == 1) {
            return amount % coins[0] == 0 ? 1 : 0;
        }
        return change(amount, coins, 0);
    }

    public static int change(int amount, int[] coins, int index) {
        if (index >= coins.length) {
            return amount == 0 ? 1 : 0;
        }
        if (amount == 0) {
            return 1;
        }
        int result = 0;
        for (int i = 0; i <= amount / coins[index]; i++) {
            result += change(amount - (coins[index] * i), coins, index + 1);
        }
        return result;
    }
    public static int change2(int amount, int[] coins) {
        if (coins == null) {
            return 0;
        }
        if (coins.length == 1) {
            return amount % coins[0] == 0 ? 1 : 0;
        }
        int[][] help = new int[coins.length+1][amount+1];
        for (int i=0;i<coins.length+1;i++){
            help[i][0] = 1;
        }
        for (int j = 0;j<=amount;j++){
            help[coins.length][amount] = 0;
        }
        for (int i = coins.length-1;i>=0;i--){
            for (int j=1;j<=amount;j++){
                help[i][j] = 0;
                for (int k=0;k<=j/coins[i];k++){
                    help[i][j]+=help[i+1][j-(coins[i]*k)];
                }
            }
        }
        return help[0][amount];
    }

}
