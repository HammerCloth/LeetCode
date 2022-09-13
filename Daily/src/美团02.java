import java.io.BufferedInputStream;
import java.nio.Buffer;
import java.util.Scanner;

/**
 * @ClassName 美团02
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/9/10 16:30
 * @Version v0.1
 **/
public class 美团02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            sum += temp;
            if (temp == 0) {
                sum += 1;
                count++;
            }
        }
        if (sum == 0){
            count++;
        }
        System.out.println(count);
    }
}
