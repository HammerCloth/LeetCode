package advanced;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author:syx
 * @date: 2021/8/26 10:03
 * @version:v1.0
 */
public class Of018 {
    public static void main(String[] args) {
        System.out.println((int)'a');//97
        System.out.println((int)'z');//122
        System.out.println((int)'A');//65
        System.out.println((int)'Z');//90
        System.out.println((int)'1');//49
        System.out.println((int)'0');//48
        System.out.println((int)'9');//57
        System.out.println(isPalindrome(""));
    }

    public static boolean isPalindrome(String s) {
        if (s.length()==0){
            return true;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp<=122&&temp>=97){
                sb.append(temp);
            }else if (temp<=57&&temp>=48){
                sb.append(temp);
            }else if (temp<=90&&temp>=65){
                sb.append((temp+"").toLowerCase());
            }
        }
        s=sb.toString();
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            if (s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
}
