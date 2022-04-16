import java.util.Scanner;

/**
 * @ClassName Test
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/2/28 5:35 PM
 * @Version v0.1
 **/
public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int N=-1;
        if(in.hasNextInt()){
            N = in.nextInt();
        }
        int M=-1;
        if(in.hasNextInt()){
            M = in.nextInt();
        }
        int K=-1;
        if(in.hasNextInt()){
            K = in.nextInt();
        }
        int matrix[][] = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                matrix[i][j] = in.nextInt();
            }
        }

        int x = N-1;
        for(int i=0;i<N;i++){
            if(matrix[i][0]>K){
                if(i>0){
                    x = i-1;
                    break;
                }
            }
        }
        for(int i=0;i<M;i++){
            if(matrix[x][i]==K){
                System.out.print(true);
                return;
            }
        }
        System.out.print(false);
    }
}
