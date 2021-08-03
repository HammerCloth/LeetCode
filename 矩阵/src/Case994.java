import java.util.LinkedList;
import java.util.Queue;

/**
 * 腐烂的橘子
 * 这段代码牛逼就牛逼在与，方向的数组，还有判断是否遍历过的数组，
 * 还有就是广度优先遍历的策略使用这两个数组，而不是使用基本的数据结构
 * @author:syx
 * @date: 2021/8/3 16:38
 * @version:v1.0
 */
public class Case994 {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{2,0}};
        int ints = orangesRotting(mat);
        System.out.println(ints);
    }
    public static int orangesRotting(int[][] grid) {
        int[][] direct = {{1,0},{0,1},{-1,0},{0,-1}};
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==0){
                    seen[i][j]=true;
                }
                if(grid[i][j]==2){
                    seen[i][j]=true;
                    grid[i][j]=0;
                    queue.offer(new int[]{i,j});
                }
            }
        }
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int row = poll[0] + direct[i][0];
                int col = poll[1] + direct[i][1];
                if (row>=0&&row<grid.length&&col>=0&&col<grid[0].length&&seen[row][col]==false){
                    grid[row][col]=grid[poll[0]][poll[1]]+1;
                    queue.offer(new int[]{row,col});
                    seen[row][col]=true;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                result = Math.max(result,grid[i][j]);
                if (seen[i][j]==false){
                    return -1;
                }
            }
        }

        return result;
    }
}
