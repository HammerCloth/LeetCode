import java.util.ArrayList;

/**
 * @ClassName Case1
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/17 10:36
 * @Version v0.1
 **/
public class Case1 {
    public static void main(String[] args) {
        System.out.println(digitSum("1234", 2));
    }
    public static String digitSum(String s, int k) {
        StringBuffer sb = new StringBuffer();
        if(s.length()<=k) return s;
        char[] chars = s.toCharArray();
        ArrayList<Integer> list = new ArrayList<>();
        for(char i:chars){
            list.add(i-'0');
        }
        for (int i = 0; i < list.size(); i+=k) {
            int[] add = new int[k];
            int temp = i;
            for (int j = 0; j < k; j++) {
                if (temp<list.size()){
                    add[j] = list.get(temp);
                    temp++;
                }else{
                    add[j] = 0;
                    temp++;
                }
            }
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += add[j];
            }
            sb.append(sum);
        }
        return digitSum(sb.toString(),k);
    }
}
