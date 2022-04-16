import java.io.BufferedInputStream;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @ClassName Case2
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/3/20 20:19
 * @Version v0.1
 **/
public class Case2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            if (n <=1) {
                System.out.println(0);
                return;
            }
            LinkedList<Integer> p1 = new LinkedList<>();
            LinkedList<Integer> p2 = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                p1.add(sc.nextInt());
            }
            for (int j = 0; j < n; j++) {
                p2.add(sc.nextInt());
            }
            int resultP1 = 0;
            while(!check(p1,p2)){
                //移动位置
                int temp = p1.pollFirst();
                p1.add(temp);
                resultP1 ++;
            }
            System.out.println(resultP1);
        }
    }
    public static boolean check(LinkedList<Integer> p1,LinkedList<Integer> p2){
        for (int i = 0; i < p1.size(); i++) {
            if(p1.get(i)!=p2.get(i)){
                return false;
            }
        }
        return true;
    }
}
