package graph;

import java.io.BufferedInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @ClassName Case844
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/3/28 09:51
 * @Version v0.1
 **/
public class Case844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] help = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                help[i][j] = sc.nextInt();
            }
        }
        System.out.println(bfs(help));
    }
    public static int bfs(int[][] help){
        int[] up = new int[]{-1,0};
        int[] down = new int[]{1,0};
        int[] right = new int[]{0,1};
        int[] left = new int[]{0,-1};
        //初始化
        Queue<int[]> queue = new LinkedList<>();
        //将起点放入
        int[] start = new int[]{0,0};
        queue.offer(start);
        int level = 0;
        //开始遍历
        while(!queue.isEmpty()){
            if(help[help.length-1][help[0].length-1]!=0){
                return level;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                if (check(help,temp,up)) {
                    help[temp[0]+up[0]][temp[1]+up[1]] = level;
                    queue.offer(new int[]{temp[0]+up[0],temp[1]+up[1]});
                }
                if (check(help,temp,down)) {
                    help[temp[0]+down[0]][temp[1]+down[1]] = level;
                    queue.offer(new int[]{temp[0]+down[0],temp[1]+down[1]});
                }
                if (check(help,temp,right)){
                    help[temp[0]+right[0]][temp[1]+right[1]] = level;
                    queue.offer(new int[]{temp[0]+right[0],temp[1]+right[1]});
                }
                if (check(help,temp,left)) {
                    help[temp[0]+left[0]][temp[1]+left[1]] = level;
                    queue.offer(new int[]{temp[0]+left[0],temp[1]+left[1]});
                }
            }
            level++;
        }
        return -1;
    }

    public static boolean check(int[][] help,int[] target,int[] vector){
        int x = target[0]+vector[0];
        int y = target[1]+vector[1];
        if (x<0||y<0||x>= help.length||y>=help[0].length){
            return false;
        }else{
            if (help[x][y]==0){
                return true;
            }else{
                return false;
            }
        }
    }
}
