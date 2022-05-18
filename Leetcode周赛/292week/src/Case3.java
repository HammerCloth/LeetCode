package src;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * @ClassName Case3
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/5/8 11:07
 * @Version v0.1
 **/
public class Case3 {
    public static void main(String[] args) {
        System.out.println(countTexts("444444444444444444444444444444448888888888888888999999999999333333333333333366666666666666662222222222222222666666666666666633333333333333338888888888888888222222222222222244444444444444448888888888888222222222222222288888888888889999999999999999333333333444444664"));
        System.out.println(countTexts("88888888888888888888888888888999999999999999999999999999994444444444444444444444444444488888888888888888888888888888555555555555555555555555555556666666666666666666666666666666666666666666666666666666666222222222222222222222222222226666666666666666666666666666699999999999999999999999999999888888888888888888888888888885555555555555555555555555555577777777777777777777777777777444444444444444444444444444444444444444444444444444444444433333333333333333333333333333555555555555555555555555555556666666666666666666666666666644444444444444444444444444444999999999999999999999999999996666666666666666666666666666655555555555555555555555555555444444444444444444444444444448888888888888888888888888888855555555555555555555555555555555555555555555555555555555555555555555555555555555555999999999999999555555555555555555555555555554444444444444444444444444444444555"));
        //System.out.println(2082876103 % 1000000007);
    }

    public static int countTexts(String pressedKeys) {
        BigDecimal result = new BigDecimal(1);
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('2', 3);
        map.put('3', 3);
        map.put('4', 3);
        map.put('5', 3);
        map.put('6', 3);
        map.put('7', 4);
        map.put('8', 3);
        map.put('9', 4);
        char[] chars = pressedKeys.toCharArray();
        int left = 0;
        int count = 1;
        char preNum = chars[0];
        int key = 1000000007;
        for (int i = 1; i < chars.length; i++) {
            if (i==chars.length-1){
                if (chars[i] != preNum) {
                    if (map.get(preNum) == 3) {
                        long count3 = count3(count);
                        result = result.multiply(new BigDecimal(count3));
                    } else {
                        long count4 = count4(count);
                        result = result.multiply(new BigDecimal(count4));
                    }
                    BigDecimal[] bigDecimals = result.divideAndRemainder(BigDecimal.valueOf((key)));
                    return bigDecimals[1].intValue();
                } else {
                    count++;
                    if (map.get(preNum) == 3) {
                        long count3 = count3(count);
                        result = result.multiply(new BigDecimal(count3));
                    } else {
                        long count4 = count4(count);
                        result = result.multiply(new BigDecimal(count4));
                    }
                    BigDecimal[] bigDecimals = result.divideAndRemainder(BigDecimal.valueOf((key)));
                    return bigDecimals[1].intValue();
                }
            }
            if (chars[i] != preNum) {
                if (map.get(preNum) == 3) {
                    long count3 = count3(count);
                    result = result.multiply(new BigDecimal(count3));
                } else {
                    long count4 = count4(count);
                    result = result.multiply(new BigDecimal(count4));
                }
                count = 1;
                preNum = chars[i];
            } else {
                count++;
            }
        }
        BigDecimal[] bigDecimals = result.divideAndRemainder(BigDecimal.valueOf((key)));
        return bigDecimals[1].intValue();
    }

    public static long count3(int num) {
        if (num == 1) return 1;
        if (num == 2) return 2;
        if (num == 3) return 4;
        long[] help = new long[num + 1];
        help[0] = 1;
        help[1] = 1;
        help[2] = 2;
        help[3] = 4;
        for (int i = 4; i <= num; i++) {
            help[i] = help[i - 1]%1000000007 + help[i - 2]% 1000000007 + help[i - 3]% 1000000007;
            //help[i] = help[i - 1]%1000000007;
            //help[i] = (help[i - 2]% 1000000007+help[i])%1000000007;
            //help[i] = (help[i - 3]% 1000000007+help[i])%1000000007;
            //help[i] = (help[i - 4]% 1000000007+help[i])%1000000007;
        }
        return help[num] %1000000007;
    }

    public static long count4(int num) {
        if (num == 1) return 1;
        if (num == 2) return 2;
        if (num == 3) return 4;
        long[] help = new long[num + 1];
        help[0] = 1;
        help[1] = 1;
        help[2] = 2;
        help[3] = 4;
        for (int i = 4; i <= num; i++) {
           // help[i] = (help[i - 1]%1000000007 + help[i - 2]% 1000000007 + help[i - 3]% 1000000007 + help[i - 4]% 1000000007)%1000000007;
            help[i] = help[i - 1]%1000000007;
            help[i] = (help[i - 2]% 1000000007+help[i])%1000000007;
            help[i] = (help[i - 3]% 1000000007+help[i])%1000000007;
            help[i] = (help[i - 4]% 1000000007+help[i])%1000000007;
        }
        return help[num] %1000000007;
    }
}
