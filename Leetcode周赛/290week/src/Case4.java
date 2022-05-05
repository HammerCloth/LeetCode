import java.util.Scanner;

/**
 * @ClassName Case4
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/24 16:34
 * @Version v0.1
 **/
public class Case4 {
    public static void main(String[] args) {

        Scanner sc  = new Scanner(System.in);
        char[] chars = sc.next().toCharArray();
        for (int i = 1; i <chars.length-1 ; i+=2) {
            System.out.println(chars[i]);
        }
        int num = sc.nextInt();
        System.out.println(num);
    }
}
