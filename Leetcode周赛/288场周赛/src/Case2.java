import java.io.BufferedInputStream;

/**
 * @ClassName Case2
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/10 10:45
 * @Version v0.1
 **/
public class Case2 {
    public static void main(String[] args) {
        String s = "999+999";
        System.out.println(minimizeResult(s));
    }
    public static String minimizeResult(String expression) {
        String s = expression;
        StringBuffer sb = new StringBuffer("("+s+")");
        String[] split = s.split("[+]");
        Integer a = Integer.valueOf(split[0]);
        Integer b = Integer.valueOf(split[1]);
        int result = a+b;
        for (int i = 1; i < split[1].length(); i++) {
            String start = split[1].substring(0, i);
            String end = split[1].substring(i);
            b = Integer.valueOf(start);
            int c = Integer.valueOf(end);
            int x = (a+b)*c;
            if (result>x){
                result = x;
                sb.delete(0,sb.length());
                sb.append("("+a+"+"+b+")"+c);
            }
        }
        a = Integer.valueOf(split[0]);
        b = Integer.valueOf(split[1]);
        for (int i = 1; i < split[0].length(); i++) {
            String start = split[0].substring(0, i);
            String end = split[0].substring(i);
            int c = Integer.valueOf(start);
            a = Integer.valueOf(end);
            int x = c*(a+b);
            if (result>x){
                result = x;
                sb.delete(0,sb.length());
                sb.append(c+"("+a+"+"+b+")");
            }
        }
        a = Integer.valueOf(split[0]);
        b = Integer.valueOf(split[1]);
        for (int i = 1; i < split[0].length(); i++) {
            String start = split[0].substring(0, i);
            String end = split[0].substring(i);
            int c = Integer.valueOf(start);
            a = Integer.valueOf(end);
            for (int j = 1; j < split[1].length(); j++) {
                start = split[1].substring(0, j);
                end = split[1].substring(j);
                b = Integer.valueOf(start);
                int d = Integer.valueOf(end);
                int x = c*(a+b)*d;
                if (result>x){
                    result = x;
                    sb.delete(0,sb.length());
                    sb.append(c+"("+a+"+"+b+")"+d);
                }
            }
        }
        return sb.toString();
    }
}
