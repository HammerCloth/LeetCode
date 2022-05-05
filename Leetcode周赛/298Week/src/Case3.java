/**
 * @ClassName Case3
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/17 11:24
 * @Version v0.1
 **/
public class Case3 {
    public static void main(String[] args) {
       maxTrailingZeros(new int[][]{{4,3,2},{7,6,1},{8,8,8}});
    }
    public static int maxTrailingZeros(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int[][] xgrid = new int[x+1][y];//总向加 x+1，y+1，y/x-1
        int[][] ygrid = new int[x][y+1];//横向加
        for (int i = 0; i < y; i++) {
            xgrid[0][i] = 1;
        }
        for (int i = 0; i < x; i++) {
            ygrid[i][0] = 1;
        }
        for (int i = 0; i < y; i++) {
            for (int j = 1; j < x+1; j++) {
                xgrid[j][i] = xgrid[j-1][i]*grid[j-1][i];
            }
        }
        for (int i = 1; i < y+1; i++) {
            for (int j = 0; j < x; j++) {
                ygrid[j][i] = ygrid[j][i-1]*grid[j][i-1];
            }
        }
        return -1;
    }
}
