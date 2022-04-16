package advanced;

/**
 * 最多删除一个字符得到回文
 *
 * @author:syx
 * @date: 2021/8/27 9:53
 * @version:v1.0
 */
public class Of019 {
    public static void main(String[] args) {
        String s = "abcccsa";

        System.out.println(validPalindrome(s));
        int left = 0;
        int right = s.length() - 1;
        while (left < s.length()) {
            System.out.println(left + ":" + s.charAt(left) + "\t" + right + ":" + s.charAt(right));
            left++;
            right--;
        }

    }

    public static boolean validPalindrome(String s) {
        boolean jump = true;
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            //System.out.println(left + ":" + s.charAt(left) + "\t" + right + ":" + s.charAt(right));
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                if ((left+1)<(right-1)&&s.charAt(left + 1) == s.charAt(right)&&s.charAt(left) == s.charAt(right - 1)) {
                    while(s.charAt(left + 1) == s.charAt(right)&&s.charAt(left) == s.charAt(right - 1)){
                        left++;
                        right--;
                    }
                } else if (s.charAt(left + 1) == s.charAt(right)) {
                    if (jump) {
                        left++;
                        jump = false;
                    } else {
                        return false;
                    }
                } else if (s.charAt(left) == s.charAt(right - 1)) {
                    if (jump) {
                        right--;
                        jump = false;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
