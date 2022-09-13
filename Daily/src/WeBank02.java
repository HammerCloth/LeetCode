import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @ClassName WeBank02
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/9/13 20:50
 * @Version v0.1
 **/
public class WeBank02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            Long a = sc.nextLong();
            Long b = sc.nextLong();
            String A = Long.toBinaryString(a);
//            System.out.print(A+"    ");
            String B = Long.toBinaryString(b);
//            System.out.println(B);
            System.out.println(check(A, B));
        }
    }

    public static int check(String A, String B) {
        if (A.length()>B.length()) return check(B,A);
        char[] charsA = A.toCharArray();
        char[] charsB = B.toCharArray();
        int i=0;
        for (; i < A.length(); i++) {
            if (charsA[i]!=charsB[i]) return -1;
        }
        int k=i;
        for (;k<B.length();k++){
            if (charsB[k]=='1') return -1;
        }
        if (i<B.length()){
            int size = B.length()-i;
            int count = 0;
            for (int j = 3; j >= 1; j--) {
                count += size/j;
                size = size%j;
            }
            return count;
        }
        return 0;
    }
}
