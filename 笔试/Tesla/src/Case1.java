/**
 * @ClassName Case1
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/30 10:09
 * @Version v0.1
 **/
public class Case1 {
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            solution(i);
            System.out.println();
        }
    }

    public static void solution(int N) {
        int enable_print = N % 10;
        while (N > 0) {
            if (enable_print == 0 && N / 10 != 0) {//10的倍数,去掉0
                enable_print = N % 10;
            } else {
                System.out.print(N % 10);
            }
            N = N / 10;
        }
    }

}
