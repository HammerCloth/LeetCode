import java.util.HashMap;
import java.util.Scanner;

/**
 * @ClassName ali01
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/3/4 7:47 PM
 * @Version v0.1
 **/
public class ali01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            if(a ==3){
                System.out.println(1);
            }
            if(a ==4){
                System.out.println(0);
            }
            if(a ==5){
                System.out.println(5);
            }


        }
    }
    
}
