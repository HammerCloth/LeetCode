import java.util.ArrayList;
import java.util.List;

/**
 * 完全平方数
 * 给定正整数n，找到若干个完全平方数，使得它们的和为n
 * 你需要让组成和的完全平方数的个数最小
 *
 * @author:syx
 * @date:2021/6/11 15:20
 * @version:v1.0
 */
public class Case279 {
    public static void main(String[] args) {
        judge();
    }

    public static void judge() {
        for (int i = 1; i < 100; i++) {
            int a = numSquares4(i);
            int b = numSquares(i);
            System.out.print(i + "\t" + numSquares4(i) + "\t");
            System.out.print(numSquares(i) + "\t");
            System.out.println(a == b);
        }
    }

    public static int numSquares(int n) {
        if (isPerfectSquare(n)) {
            return 1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (isPerfectSquare(i)) {
                list.add(i);
            }
        }
        return numSquares(list, n, 0);

    }

    public static int numSquares(List<Integer> list, int n, int index) {
        if (n == 0) {
            return 0;
        } else {
            if (index >= list.size()) {
                return (int) Math.pow(10, 4);
            }
        }
        int count = Integer.MAX_VALUE;
        int times = n / list.get(index);
        for (int i = 0; i <= times; i++) {
            count = Math.min(count, i + numSquares(list, n - list.get(index) * i, index + 1));
        }
        return count;
    }

    public static boolean isPerfectSquare(int n) {
        return Math.sqrt(n) % 1 == 0;
    }

    public static int numSquares2(int n) {
        if (isPerfectSquare(n)) {
            return 1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (isPerfectSquare(i)) {
                list.add(i);
            }
        }
        System.out.println(list.toString());
        int[][] help = new int[list.size() + 1][n + 1];
        for (int i = 0; i < help.length; i++) {
            help[i][0] = 0;
        }

        for (int j = 1; j < help[1].length; j++) {
            help[list.size()][j] = 10000;
        }

        for (int index = list.size() - 1; index >= 0; index--) {//i 为index，j为当前的n
            for (int n1 = n; n1 >= 1; n1--) {
                int count = Integer.MAX_VALUE;
                int times = n1 / list.get(index);
                for (int i = 0; i <= times; i++) {
                    count = Math.min(count, i + help[index + 1][n1 - list.get(index) * i]);
                }
                help[index][n1] = count;
            }
        }
        return help[0][n];
    }

    public static void show(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                System.out.print(nums[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int numSquares3(int n) {
        if (isPerfectSquare(n)) {
            return 1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (isPerfectSquare(i)) {
                list.add(i);
            }
        }
        return numSquares3(list, n);

    }

    public static int numSquares3(List<Integer> list, int n) {
        if (isPerfectSquare(n)) {
            return 1;
        }
        if (n==0){
            return 1;
        }
        if (n<0){
            return 10000;
        }
        int count = Integer.MAX_VALUE;
        for (int i:list){
            count = Math.min(count,1+numSquares3(list,n-i));
        }
        return count;
    }

    public static int numSquares4(int n) {
        List<Integer> list = new ArrayList<>();
        for (int k = 1; k <= n; k++) {
            if (isPerfectSquare(k)) {
                list.add(k);
            }
        }
        int[] help = new int[n+1];
        help[0] = 1;
        for (int i = 1;i<n+1;i++){
            if (isPerfectSquare(i)){
                help[i]=1;
            }else{
                int count = Integer.MAX_VALUE;
                for (int j=0;j<list.size()&&list.get(j)<=i;j++){
                    count = Math.min(count,1+help[i-list.get(j)]);
                }
                help[i]=count;
            }

        }
        return help[n];
    }
}
