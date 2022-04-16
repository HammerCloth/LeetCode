import java.io.BufferedInputStream;
import java.util.*;

/**
 * @ClassName Case1
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/3/24 19:02
 * @Version v0.1
 **/
public class Case1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        char[] chars = sc.nextLine().toCharArray();
        List<Character> array = new ArrayList<>();
        for (char c:chars) {
            array.add(c);
        }
        int n = chars.length;
        int temp = 0;
        while(!check(temp,n,array)){
            temp += 7;
        }
        System.out.println(temp);
    }

    public static boolean check(Integer temp,int n,List<Character> array){
        int len = temp.toString().length();
        if (len!=(n+1)){
            return false;
        }else{
            char[] chars = temp.toString().toCharArray();
            boolean flag = true;
            int left = 0;
            int right = 0;
            for (int i = 0; i < n; i++) {
                if (chars[left]==array.get(right)){
                    left++;
                    right++;
                }else{
                    if(flag){
                        flag = false;
                        left++;
                    }else{
                        return false;
                    }
                }
            }
            return true;
        }
    }


}
