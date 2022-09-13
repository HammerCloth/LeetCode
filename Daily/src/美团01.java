import java.io.BufferedInputStream;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @ClassName 美团01
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/9/10 15:56
 * @Version v0.1
 **/
public class 美团01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            long n = sc.nextLong();
            long x = sc.nextLong();
            long y = sc.nextLong();
            long k = sc.nextLong();
            result(n,x,y,k);
        }

    }

    public static void result(long n,long x ,long y,long k){
        BigDecimal one = new BigDecimal(n).subtract(new BigDecimal(k)).add(new BigDecimal(1));
        BigDecimal X = new BigDecimal(x);
        BigDecimal Y = new BigDecimal(y);
        BigDecimal two = new BigDecimal(k);

        BigDecimal A = Y.multiply(two);
        BigDecimal B = X.multiply(one);

        if (A.compareTo(B)>0){
            System.out.println("Lose");
        }else if (A.compareTo(B)<0){
            System.out.println("Win");
        }else{
            System.out.println("Tie");
        }

    }
}
