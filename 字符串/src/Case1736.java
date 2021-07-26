/**
 * 替换隐藏数字得到的最晚时间
 * 给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
 * 有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
 * 替换time 中隐藏的数字，返回你可以得到的最晚有效时间。
 * @author:syx
 * @date: 2021/7/24 9:19
 * @version:v1.0
 */
public class Case1736 {
    public static void main(String[] args) {
        System.out.println(maximumTime("?4:?0"));
    }
    public static String maximumTime(String time) {
        char[] clock = time.toCharArray();
        for (int i = 0; i < clock.length; i++) {
            if (clock[i]=='?'){
                format(clock,i);
            }
        }
        return new String(clock);
    }

    public static void format(char[] clock,int i){
        if (i==0){
            if (clock[1]=='?'||Integer.parseInt(clock[1]+"")<=3){//直接用asc码来比较比较好，这样快
                clock[i]='2';
            }else{
                clock[i]='1';
            }

        }
        if (i==1){
            if (clock[0]=='2'){
                clock[i]='3';
            }else{
                clock[i]='9';
            }
        }
        if (i==3){
            clock[i]='5';
        }
        if (i==4){
            clock[i]='9';
        }
    }
}
