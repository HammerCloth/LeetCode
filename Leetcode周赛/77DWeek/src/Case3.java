/**
 * @ClassName Case3
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/30 23:04
 * @Version v0.1
 **/
public class Case3 {
    public static void main(String[] args) {

    }
    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] graph = new int[m][n];//建立图，全为0；
        for (int i = 0; i < guards.length; i++) {
            int row = guards[i][0];
            int col = guards[i][1];
            graph[row][col] = 1;//代表警察
        }
        for (int i = 0; i < walls.length; i++) {
            int row = walls[i][0];
            int col = walls[i][1];
            graph[row][col] = 2;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1) {
                    change(graph,i,j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void change(int[][] graph, int x, int y) {
        //上下左右
        int[] dirX = new int[]{-1, 1, 0, 0};
        int[] dirY = new int[]{0, 0, -1, 1,};
        //向上走
        int i = 1;
        while(check(graph,x-i,y)){
            graph[x-i][y] = -1;
            i++;
        }
        //向下走
        i = 1;
        while(check(graph,x+i,y)){
            graph[x+i][y] = -1;
            i++;
        }
        //向左
        i = 1;
        while(check(graph,x,y-i)){
            graph[x][y-i] = -1;
            i++;
        }
        //向右
        i = 1;
        while(check(graph,x,y+i)){
            graph[x][y+i] = -1;
            i++;
        }
    }

    public static boolean check(int[][] graph, int x, int y){
        if (x<0||x>=graph.length||y<0||y>=graph[0].length){
            return false;
        }else{
            if (graph[x][y]==2||graph[x][y]==1){
                return false;
            }
        }
        return true;
    }
}
