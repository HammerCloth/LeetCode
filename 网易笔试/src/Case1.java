import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @ClassName Case1
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/3/17 19:23
 * @Version v0.1
 **/
public class Case1 {
    // a+b 11机制 0-9 a
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        String a = sc.next();
        String b = sc.next();
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
    }
    
    public static int[] add11(int[] a,int []b){
        if (a.length<b.length){//长度最长为a
            int[] temp = a;
            a = b;
            b = temp;
        }
        int length = Math.max(a.length,b.length)+1;
        int[] result = new int[length];
        // 数组的低位存储最低位
        int t = 0;
        for (int i = 0; i < length-1; i++) {
            if (i<b.length){
                result[i] = (a[i]+b[i]+t)%11;
                t = (a[i]+b[i]+t)/11;
            }else{
                result[i] = (a[i]+t)%11;
                t = (a[i]+t)/11;
            }
        }
        result[length-1] = t;
        return result;
    }
}
