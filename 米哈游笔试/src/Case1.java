import java.io.BufferedInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @ClassName Case1
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/3/20 20:19
 * @Version v0.1
 **/
public class Case1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int q = sc.nextInt();
        Queue<int[]>  queue = new LinkedList<>();
        for (int i = 0; i < q; i++) {
            int key = sc.nextInt();
            if (key==1){
                int[] temp = new int[2];
                temp[0] = sc.nextInt();
                temp[1] = sc.nextInt();
                queue.offer(temp);
            }else{//key=2;
                if (queue.size()==0){
                    System.out.println("no reliquaries.");
                }else{
                    int[] temp = queue.poll();
                    System.out.println(temp[0]+" "+temp[1]);
                }
            }
        }
    }
}
