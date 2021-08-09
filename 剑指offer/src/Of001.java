/**
 * 整数除法
 *
 * @author:syx
 * @date: 2021/8/9 9:27
 * @version:v1.0
 */
public class Of001 {
    public static void main(String[] args) {
        System.out.println(divide(-2147483648,-1));
    }

    public static int divide(int a, int b) {
        if (a==-2147483648&&b==1){
            return -2147483648;
        }
        long al = (long)a;
        long bl = (long)b;
        int key = 1;
        if (al<0&bl>0){
            key = -1;
            al = -al;
        }
        if (al>0&bl<0){
            key = -1;
            bl=-bl;
        }
        if (al<0&&bl<0){
            al=-al;
            bl=-bl;
        }
        if (al < bl) {
            return 0;
        }
        int result = 0;
        while(al>=bl){
            int temp = 1;
            long base = bl;
            while((base<<1)<=al){
               base = base<<1;
               temp = temp<<1;
            }
            al -= base;
            result+=temp;
        }
        if (result<0){
            result=Integer.MAX_VALUE;
        }
        if (key ==1){
            return (int)result;
        }else{
            return -(int)result;
        }
    }
}
