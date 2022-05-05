import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Case3
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/23 16:41
 * @Version v0.1
 **/
public class Case3 {
    public int numIslands(char[][] grid) {
        //每一个点如果是岛的话就进行DFS
        //dfs将这个点相关联的部分，全部变为水即可
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res += 1;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    static int[] LEFT = new int[]{-1, 0};
    static int[] RIGHT = new int[]{1, 0};
    static int[] UP = new int[]{0, -1};
    static int[] DOWN = new int[]{0, 1};

    public static void dfs(char[][] grid, int x, int y) {
        if (x < 0 || x > grid.length || y < 0 || y > grid[0].length) return;
        if (grid[x][y] == '0') return;
        grid[x][y] = '0';//改变这个岛屿的属性
        //向四周进行遍历
        dfs(grid, x + UP[0], y + UP[1]);
        dfs(grid, x + DOWN[0], y + DOWN[1]);
        dfs(grid, x + LEFT[0], y + LEFT[1]);
        dfs(grid, x + RIGHT[0], y + RIGHT[1]);
    }
}
