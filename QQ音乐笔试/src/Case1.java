import java.util.Arrays;

/**
 * @ClassName Case1
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/7 19:06
 * @Version v0.1
 **/
public class Case1 {
    public static void main(String[] args) {
        System.out.println(numsOfStrings2(2, 1));
    }
    public static int numsOfStrings (int n, int k) {
        if (k==1){
            return 26;
        }
        if (k==0){
            return 0;
        }
        int result = 0;
        for (int i = 2; i <= n-2; i++) {
            result+= 25*numsOfStrings(n-i,k-1);
        }
        return result;
    }

    public static int numsOfStrings2 (int n, int k) {
        int[][] help = new int[n+1][k+1];
        for (int i = 2; i < n+1; i++) {
            help[i][1] = 26;
        }
        for (int i = 2; i <=k ; i++) {
            for (int j = 2; j <=n ; j++) {
                int result = 0;
                for (int l = 2; l <= j; l++) {
                    result+= 25*help[j-l][i-1];
                }
                help[j][i] = result;
            }
        }
        return help[n][k]%1000000;
    }

}
