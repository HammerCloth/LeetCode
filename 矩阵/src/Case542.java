import java.util.*;

/**
 * 01矩阵
 *
 * @author:syx
 * @date:2021/8/3 15:25
 * @version:v1.0
 */
public class Case542 {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{0}};
        int[][] ints = updateMatrix(mat);
        Case1893.print2D(ints);
    }
    public static int[][] updateMatrix(int[][] mat) {
        int[][] direct = {{1,0},{0,1},{-1,0},{0,-1}};
        boolean[][] seen = new boolean[mat.length][mat[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if(mat[i][j]==0){
                    seen[i][j]=true;
                    queue.offer(new int[]{i,j});
                }
            }
        }

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int row = poll[0] + direct[i][0];
                int col = poll[1] + direct[i][1];
                if (row>=0&&row<mat.length&&col>=0&&col<mat[0].length&&seen[row][col]==false){
                    mat[row][col]=mat[poll[0]][poll[1]]+1;
                    queue.offer(new int[]{row,col});
                    seen[row][col]=true;
                }
            }
        }
    return mat;
    }

}
