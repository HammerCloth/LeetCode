import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName Case3
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/2 22:40
 * @Version v0.1
 **/
public class Case3 {
    public static void main(String[] args) {
        System.out.println(numberOfWays("011101"));
    }

    public static long numberOfWays(String s) {
        char[] chars = s.toCharArray();
        int[] array = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            array[i] = chars[i]-'0';
        }
        return numberOfWays(array,0,array.length,3,-1);
    }
    public static long numberOfWays(int[] array,int left,int right,int count,int lastnum){
        if (count==0){
//            System.out.println(help);
            return 1;
        }
        if (left>=right){
            return 0;
        }
        int result = 0;
        if ((left<right&&lastnum!=array[left])){
            result+=numberOfWays(array,left+1,right,count-1,array[left]);
        }
        result+=numberOfWays(array,left+1,right,count,lastnum);
        return result;

    }

}
