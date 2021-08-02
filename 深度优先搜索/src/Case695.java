import java.util.*;

/**
 * @author:syx
 * @date:2021/8/1 9:51
 * @version:v1.0
 */
public class Case695 {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}};

        System.out.println(maxAreaOfIsland(grid));
    }

    public static  int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==1){
                    int area = getArea(grid,i,j);
                    result = Math.max(result, area);
                }
            }
        }
        return result;
    }

    public static int getArea(int[][] grid,int s1,int s2){
        grid[s1][s2] = 0;
        Queue<int[]> queue = new LinkedList<int[]>() {
        };
        int area = 1;
        queue.offer(new int[]{s1,s2});
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            if (poll[1]-1>=0){
                if (grid[poll[0]][poll[1]-1]==1){
                    grid[poll[0]][poll[1]-1]=0;
                    queue.offer(new int[]{poll[0],poll[1]-1});
                    area++;
                }
            }
            //下
            if (poll[1]+1<=grid[0].length-1){
                if (grid[poll[0]][poll[1]+1]==1){
                    grid[poll[0]][poll[1]+1]=0;
                    queue.offer(new int[]{poll[0],poll[1]+1});
                    area++;
                }
            }
            //右
            if (poll[0]+1<=grid.length-1){
                if (grid[poll[0]+1][poll[1]]==1){
                    grid[poll[0]+1][poll[1]]=0;
                    queue.offer(new int[]{poll[0]+1,poll[1]});
                    area++;
                }
            }
            //左
            if (poll[0]-1>=0){
                if (grid[poll[0]-1][poll[1]]==1){
                    grid[poll[0]-1][poll[1]]=0;
                    queue.offer(new int[]{poll[0]-1,poll[1]});
                    area++;
                }
            }
        }
        return area;
    }
}
