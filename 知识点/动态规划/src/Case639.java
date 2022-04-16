/**
 * @author:syx
 * @date: 2021/9/27 9:49
 * @version:v1.0
 */
public class Case639 {
    public static void main(String[] args) {
        System.out.println(numDecodings("3*"));
    }

    public static int numDecodings(String s) {
        if (s.length() == 1) {
            if (s.equals("*")) {
                return 9;
            } else {
                return 1;
            }
        }
        if (s.length() < 1) {
            return 0;
        }
        //todo 调用递归得解
        return (int) (numDecodings(s.toCharArray(), 0) % (Math.pow(10, 9) + 7));
    }

    public static long numDecodings(char[] chars, int start) {
        if (start == chars.length - 1) {
            if (chars[start] == '*') {
                return 9;
            } else {
                // 0~9
                return 1;
            }
        }
        if (start == chars.length - 2) {
            if (chars[start] == '*') {
                if (chars[start + 1] == '*') {
                    return 15 + 9 * 9;
                } else if (chars[start + 1] == '7' || chars[start + 1] == '8' || chars[start + 1] == '9') {
                    return 3 + 9 * 3;
                } else {
                    //0~6
                    return 9 + 2;
                }
            } else if (chars[start] == '1') {
                if (chars[start + 1] == '*') {
                    return 1 * 9 + 9;
                } else {
                    //0~9
                    return 10 + 10;
                }
            } else if (chars[start] == '2') {
                if (chars[start + 1] == '*') {
                    return 1 * 9 + 6;
                } else if (chars[start + 1] == '7' || chars[start + 1] == '8' || chars[start + 1] == '9') {
                    return 3;
                } else {
                    //0~6
                    return 7 + 7;
                }
            } else {
                if (chars[start + 1] == '*') {
                    return 9;
                }
                return 1;
            }
        }
        if (chars[start] == '*') {
            if (chars[start + 1] == '*') {
                return 9 * numDecodings(chars, start + 1) + 15 * numDecodings(chars, start + 2);
            } else if (chars[start + 1] == '7' || chars[start + 1] == '8' || chars[start + 1] == '9') {
                return 9 * numDecodings(chars, start + 1) + 3 * numDecodings(chars, start + 2);
            } else {
                //0~6
                return 9 * numDecodings(chars, start + 1) + 2 * numDecodings(chars, start + 2);
            }
        } else if (chars[start] == '1') {
            if (chars[start + 1] == '*') {
                return numDecodings(chars, start + 1) + 9 * numDecodings(chars, start + 2);
            } else {
                //0~9
                return numDecodings(chars, start + 1) + numDecodings(chars, start + 2);
            }
        } else if (chars[start] == '2') {
            if (chars[start + 1] == '*') {
                return numDecodings(chars, start + 1) + 5 * numDecodings(chars, start + 2);
            } else if (chars[start + 1] == '7' || chars[start + 1] == '8' || chars[start + 1] == '9') {
                return numDecodings(chars, start + 1);
            } else {
                //0~6
                return numDecodings(chars, start + 1) + numDecodings(chars, start + 2);
            }
        } else {
            // 0,3~9
            if (chars[start + 1] == '*') {
                return numDecodings(chars, start + 1) +  numDecodings(chars, start + 2);
            }
            return numDecodings(chars, start++);
        }
    }
}
