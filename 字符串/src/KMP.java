import java.util.Arrays;

/**
 * @author:syx
 * @date:2021/6/26 16:27
 * @version:v1.0
 */
public class KMP {

    public static void main(String[] args) {
        String a = "abcabc";
        System.out.println(Arrays.toString(createNext(a)));
    }
    public static int[] createNext(String str) {
        if (str.length() == 1) {
            return new int[]{1};
        }
        char[] strs = str.toCharArray();
        int[] next = new int[strs.length];
        next[0] = -1;
        next[1] = 0;
        int cn = 0;
        int i = 2;
        while(i<next.length){
            if (strs[i-1]==strs[cn]){
                next[i++]=++cn;
            }else if(cn>0){
                cn = next[cn];
            }else{
                next[i++] = 0;
            }
        }
        return next;
    }
}
