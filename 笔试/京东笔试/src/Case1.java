import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @ClassName Case1
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/3/19 19:30
 * @Version v0.1
 **/
public class Case1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int all = b * d;//总的生命值
        System.out.println(fire(a, c, all, b, 0));
    }

    public static int fire(int a, int c, int all, int b, int level) {
        if (a <= 0 && all > 0) {
            return -1;
        }
        if(a>=0&&all<=0){
            return level;
        }
        all = all - a;//进攻一轮
        int num = all / b;
        if (all % b != 0) num++;
        a -= num * c;
        level++;
        return fire(a, c, all, b, level);

    }
}
