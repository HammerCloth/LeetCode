/**
 * @ClassName Case1
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/5/14 22:24
 * @Version v0.1
 **/
public class Case1 {
    public static void main(String[] args) {
        System.out.println(divisorSubstrings(00, 2));
    }
    public static int divisorSubstrings(int num, int k) {
        String s = num+"";
        int count = 0;
        for (int i = 0; i < s.length()-k+1; i++) {
            System.out.println(s.substring(i, i + k));
            Integer key = Integer.valueOf(s.substring(i, i + k));
            System.out.println(key);
            if (key!=0&&num%key==0) count++;
        }
        return count;
    }
}
