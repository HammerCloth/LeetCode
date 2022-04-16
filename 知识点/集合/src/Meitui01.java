import java.util.*;

/**
 * @ClassName Meitui01
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/3/5 10:03 AM
 * @Version v0.1
 **/
public class Meitui01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int N = sc.nextInt();
            Set<Integer> set = new HashSet<>();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                int temp = sc.nextInt();
                if (!set.contains(temp)){
                    set.add(temp);
                    list.add(temp);
                }
            }
            Collections.sort(list);
            int size = 1;
            int x = list.get(0);
            for (int i = 0; i < list.size(); i++) {
                int temp = list.get(i);
                if (temp - x>1){
                    size++;
                    x = temp;
                }
            }
            System.out.println(size);

        }
    }
}
