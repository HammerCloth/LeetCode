import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @ClassName Case937
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/5/3 10:15
 * @Version v0.1
 **/
public class Case937 {
    public static void main(String[] args) {
        String[] strings = reorderLogFiles(new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"});
        Arrays.stream(strings).forEach(System.out::println);
        System.out.println("****************************************");
        strings = reorderLogFiles(new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"});
        Arrays.stream(strings).forEach(System.out::println);
    }
    public static String[] reorderLogFiles(String[] logs) {
        List<String> list = new ArrayList<>();//用来存放原有顺序的数字日志
        List<String> listA = new ArrayList<>();//用来存放需要排序的字母日志
        for (int i = 0; i < logs.length; i++) {
            String log = logs[i];
            if (Pattern.matches("[0-9]", log.substring(log.length() - 1))) {//使用正则表达式
                list.add(log);//数字表示正常顺序
            } else {
                listA.add(log);
            }
        }
        Collections.sort(listA, (a, b) -> {
            //获得第一个" "
            //将字符串分割
            //分别获得排序结果
            int i = a.indexOf(" ");
            String preA = a.substring(0, i);
            String endA = a.substring(i + 1);
            int j = b.indexOf(" ");
            String preB = b.substring(0, j);
            System.out.println(preB);
            String endB = b.substring(j + 1);
            System.out.println(endB);
            int preCom = preA.compareTo(preB);
            int endCom = endA.compareTo(endB);
            if (endCom == 0) {
                return preCom;
            } else {
                return endCom;
            }
        });
        String[] result = new String[logs.length];
        int k = 0;
        for (int i = 0; i < listA.size(); i++) {
            result[k++] = listA.get(i);
        }
        for (int i = 0; i < list.size(); i++) {
            result[k++] = list.get(i);
        }
        return result;
    }
    public static int compare(String a,String b){
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        int size = Math.min(A.length,B.length);
        for (int i = 0; i < size; i++) {
            if (A[i]!=B[i]){
                return A[i]-B[i];
            }
        }
        return 0;

    }
}
