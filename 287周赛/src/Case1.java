/**
 * @ClassName Case1
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/3 10:28
 * @Version v0.1
 **/
public class Case1 {
    public static void main(String[] args) {
        System.out.println(convertTime("11:00", "11:01"));
    }
    public static  int convertTime(String current, String correct) {
        String[] split = current.split(":");
        int a = Integer.valueOf(split[0]) * 60 + Integer.valueOf(split[1]);
        split = correct.split(":");
        int b = Integer.valueOf(split[0]) * 60 + Integer.valueOf(split[1]);
        int c = b-a;
        int result = 0;
        result += c/60;
        c = c%60;
        result += c/15;
        c = c%15;
        result+= c/5;
        c = c%5;
        result += c;
        return result;
    }
}
