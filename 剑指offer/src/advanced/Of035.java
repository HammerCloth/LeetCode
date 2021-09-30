package advanced;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author:syx
 * @date: 2021/9/9 10:13
 * @version:v1.0
 */
public class Of035 {
    public static void main(String[] args) {
        List<String> timePoints = new ArrayList<>();
        timePoints.add("05:31");
        timePoints.add("22:08");
        timePoints.add("00:35");
        System.out.println(findMinDifference(timePoints));
    }
    public static int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 24 * 60) {
            return 0;
        }
        List<Integer> help = new ArrayList<>();
//        todo 初始化
        for(int i=0;i< timePoints.size();i++){
            String str = timePoints.get(i);
            if (str.equals("00:00")){
                help.add(0);
                help.add(24*60);
            }else{
                help.add(translate(str));
            }
        }
//        todo 排序
        Collections.sort(help);
//        todo 判断相邻时间
        int result = Integer.MAX_VALUE;
        for (int i = 0,j=1; j < help.size(); i++,j++) {
            result = Math.min(help.get(j)-help.get(i),result);
        }
        int lastIndex = help.size()-1;
        int other = 24*60-help.get(lastIndex)+help.get(0);
        if (other!=0){
            result = Math.min(other,result);
        }
        return result;
    }

    public static int translate(String s){
        char[] chars = s.toCharArray();
        int result = Integer.parseInt(chars[0]+""+chars[1]+"")*60+Integer.parseInt(chars[3]+""+chars[4]+"");
        return result;
    }
}
