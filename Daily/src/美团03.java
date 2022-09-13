import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName 美团03
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/9/10 16:39
 * @Version v0.1
 **/
public class 美团03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        Long[] room = new Long[n];
        Long[] weight = new Long[n];
        Map<String,Long> map = new HashMap<>();
        long edge = 0l;
        for (int i = 0; i < n; i++) {
            room[i] = sc.nextLong();
            if (edge<room[i]) edge=room[i];
        }
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextLong();
        }
        for (int i = 0; i < n; i++) {
            if (map.containsKey(room[i]+"")){
                map.put(room[i]+"",map.get(room[i]+"")+weight[i]);
            }else{
                map.put(room[i]+"",weight[i]);
            }
        }
        long[] help = new long[(int) (edge+1)];
        for (int i = help.length-1; i >=0; i--) {
            long extra = 0;
            if(2*i+1<help.length){
                extra = Math.max(help[2*i],help[2*i+1]);
            }
            if (map.containsKey(i+"")){
                extra = map.get(i+"")+extra;
            }
            help[i] = extra;
        }
        System.out.println(help[1]);
    }
}
