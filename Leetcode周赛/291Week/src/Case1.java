import java.math.BigDecimal;

/**
 * @ClassName Case1
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/5/1 10:10
 * @Version v0.1
 **/
public class Case1 {
    public static void main(String[] args) {
        String number = "1231";
        System.out.println(removeDigit(number, '1'));
    }
    public static String removeDigit(String number, char digit) {
        String count = "0";
        char[] chars = number.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]==digit){
                String temp = number.substring(0,i)+number.substring(i+1);
                if (count.length()<temp.length()){
                    count = temp;
                }else{
                    if (check(count,temp)) count = temp;
                }
            }
        }
        return count+"";
    }
    public static boolean check(String a,String b){
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        for (int i = 0; i < a.length(); i++) {
            if ((charsB[i]-'0')>(charsA[i]-'0')){
                return true;
            }else if((charsB[i]-'0')<(charsA[i]-'0')){
                return false;
            }
        }
        return false;
    }
}
