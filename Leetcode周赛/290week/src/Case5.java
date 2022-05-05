import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @ClassName Case5
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/24 17:11
 * @Version v0.1
 **/
public class Case5 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        char[] chars = sc.next().toCharArray();
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <chars.length-1 ; i+=2) {
            set.add(chars[i]-'0');
        }
        int num = sc.nextInt();
        if (set.contains(num)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
