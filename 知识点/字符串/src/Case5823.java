import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author:syx
 * @date:2021/7/25 10:31
 * @version:v1.0
 */
public class Case5823 {
    public static void main(String[] args) {
        System.out.println(getLucky("iiii", 1));
    }
    public static int getLucky(String s, int k) {
        BigDecimal number = getNumber(s);
        int result = change(number);
        for (int i=2;i<=k;i++){
            result = change(result);
        }
        return result;
    }
    public static BigDecimal getNumber(String s){
        char[] chars = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<chars.length;i++){
            String temp = Integer.toString((int)chars[i]-96);
            sb.append(temp);
        }
        return new BigDecimal(sb.toString());

    }
    public static int change(BigDecimal s){
        char[] chars = s.toString().toCharArray();
        int number = 0;
        for (int i=0;i<chars.length;i++){
            number+=Integer.parseInt(chars[i]+"");
        }
        return number;
    }
    public static int change(int s){
        char[] chars = Integer.toString(s).toCharArray();
        int number = 0;
        for (int i=0;i<chars.length;i++){
            number+=Integer.parseInt(chars[i]+"");
        }
        return number;
    }
}
