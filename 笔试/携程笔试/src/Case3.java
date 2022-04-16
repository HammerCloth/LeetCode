import java.util.HashMap;
import java.util.Scanner;

/**
 * @ClassName Case3
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/3/24 20:28
 * @Version v0.1
 **/
public class Case3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        char[] chars = sc.next().toCharArray();
        System.out.println(result(k, n, chars));
    }
    public static int result(int k,int n,char[] chars){
        int left =0;
        int right = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int result = 0;
        while(right<=n){
            if (map.size()<k){
                right++;
                char temp = chars[right];
                if (map.containsKey(temp)){

                    map.put(temp,map.get(temp)+1);
                }else{
                    map.put(temp,1);
                }
            }else if(map.size()==k){
                result = Math.max(result,right-left);
                char temp = chars[left];
                int value = map.get(temp);
                if (value==1){
                    map.remove(temp);
                }else{
                    map.put(temp,value-1);
                }
                left++;
            }
        }
        return result;
    }
}
