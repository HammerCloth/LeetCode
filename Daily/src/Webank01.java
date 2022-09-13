import java.io.BufferedInputStream;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @ClassName Webank01
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/9/13 20:23
 * @Version v0.1
 **/
public class Webank01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        PriorityQueue<String> heap = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                //选最长的
                //相同长度选最大的
                if (a.length()==b.length()){
                    return -(Integer.parseInt(a)-Integer.parseInt(b));
                }else{
                    return -(a.length()-b.length());
                }
            }
        });
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            heap.offer(k+"");
        }
        PriorityQueue<String> heapA = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                //选最长的
                //相同长度选最大的
                if(a.length()>b.length()) return compare(b,a);
                char[] charsA = a.toCharArray();
                char[] charsB = b.toCharArray();
                int i=0;
                for (; i < charsA.length; i++) {
                    if (charsA[i]!=charsB[i]){
                        return charsB[i]-charsA[i];
                    }
                }
                if(i<charsB.length){
                    return charsB[i]-charsA[charsA.length-1];
                }
                return 0;
            }
        });
        for (int i = 0; i < 3; i++) {
            heapA.offer(heap.poll());
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            sb.append(heapA.poll());
        }
        System.out.println(sb.toString());
    }
}
