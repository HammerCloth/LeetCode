import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Case2
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/3/24 19:37
 * @Version v0.1
 **/
public class Case2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toCharArray();
        System.out.println(result(chars,0,chars.length-1));

    }
    public static int result(char[] chars,int left,int right){
        if (left>=2){
            if (chars[left-1]==chars[left-2]){
                return Integer.MAX_VALUE>>2;
            }
        }
        if (left==right){
            if (left>0&&chars[left-1]==chars[left]){
                return Integer.MAX_VALUE>>2;
            }
            System.out.println(Arrays.toString(chars));
            return 0;
        }
        int case2 = result(chars, left+1, right);
        //case1
        if (chars[left]=='0'){
            chars[left]='1';
        }else{
            chars[left] = '0';
        }
        int case1 = left+1+result(chars,left+1,right);
        if (chars[left]=='0'){
            chars[left]='1';
        }else{
            chars[left] = '0';
        }
        return Math.min(case1,case2);
    }
}
