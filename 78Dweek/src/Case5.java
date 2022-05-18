import java.util.Arrays;
import java.util.HashSet;

/**
 * @ClassName Case5
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/5/15 10:50
 * @Version v0.1
 **/
public class Case5 {
    public static void main(String[] args) {
        maxConsecutive(2,9,new int[]{4,6});
    }
    public static int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int relax = 0;
        int i = bottom;
        int result = 0;
        while(i<=top){
            if (relax<special.length){
                int count = special[relax]-i;
                result = Math.max(result,count);
                i = special[relax]+1;
                relax++;
            }else{
                int count = top-i+1;
                result = Math.max(count,result);
                i = top+1;
            }
        }
        return result;
    }
}
