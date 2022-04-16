import java.util.Arrays;

/**
 * @author:syx
 * @date:2021/6/26 16:27
 * @version:v1.0
 */
public class KMP {

    public static void main(String[] args) {
        String a = "abcabc";
        System.out.println(kmp(a,"z"));
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

    /**
     * 模式匹配
     * 返回b在a中的位置，如果a中没有b则返回-1
     * @param a
     * @param b
     * @return
     */
    public static int kmp(String a,String b){

        if (a.length()<b.length()){
            return -1;
        }

        if (a.equals(b)){
            return 0;
        }

        int[] next = createNext(b);
        char[] str1 = a.toCharArray();
        char[] str2 = b.toCharArray();

        int i=0;
        int j=0;

        while(i<str1.length&&j<str2.length){
            if (str1[i]==str2[j]) {
                i++;
                j++;
            }else if(next[j]==-1){
                i++;
                j=0;
            }else{
                j=next[j];
            }
        }

        if (j==str2.length){
            return i-str2.length;
        }else{
            return -1;
        }

    }
}
