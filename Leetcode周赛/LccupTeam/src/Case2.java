/**
 * @ClassName Case2
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/23 14:48
 * @Version v0.1
 **/
public class Case2 {
    public static void main(String[] args) {

        Case2 c = new Case2();

        int i = c.conveyorBelt(new String[]{">V"}, new int[]{0, 0}, new int[]{0, 1});
        System.out.println(i);
        i = c.conveyorBelt(new String[]{">^^>", "<^v>", "^v^<"}, new int[]{0, 0}, new int[]{1, 3});
        System.out.println(i);
        i = c.conveyorBelt(new String[]{">>v", "v^<", "<><"}, new int[]{0, 1}, new int[]{2, 0});
        System.out.println(i);

    }

    public int conveyorBelt(String[] matrix, int[] start, int[] end) {
        if (end[1] == start[1] && end[0] == start[0]) {
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length();
        char[][] array = new char[n][m];
        for (int i = 0; i < n; i++) {
            char[] chars = matrix[i].toCharArray();
            array[i] = chars;
        }
        boolean[][] state = new boolean[n][m];//对应路径是否走过，最开始全部为false
        int[][] help = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                help[i][j] = Integer.MIN_VALUE;
            }
        }
        help[end[0]][end[1]] = 0;

        return conveyorBelt(array, start, end, state, help);
    }

    static int[] UP = new int[]{-1, 0};
    static int[] DOWN = new int[]{1, 0};
    static int[] LEFT = new int[]{0, -1};
    static int[] RIGHT = new int[]{0, 1};

    public int conveyorBelt(char[][] array, int[] start, int[] end, boolean[][] state, int[][] help) {
        if (end[1] == start[1] && end[0] == start[0]) {
            return 0;
        }//如果走到了终点，那么直接不需要做任何施法，直接返回0
        int result = Integer.MAX_VALUE / 3;//如果result不能更新，则代表四条路都不能走，返回这个最大值
        //dfs过程
        //up
        int[] up = next(start, UP);
        if (out(array, up) && !state[up[0]][up[1]]) {//不出界，并且没有走过
            //表示这一步可以走
            int plus = 0;
            if (array[start[0]][start[1]] != '^') {//如果不是这个方向就需要使用魔法
                plus = 1;
            }
            state[start[0]][start[1]] = true;//走过了
            int sum;
            if (help[up[0]][up[1]] != Integer.MIN_VALUE) {
                sum = help[up[0]][up[1]] + plus;
            } else {
                sum = conveyorBelt(array, up, end, state, help) + plus;
            }
            result = Math.min(sum, result);//获得最小的步数
            state[start[0]][start[1]] = false;//还原现场
        }
        //down
        up = next(start, DOWN);
        if (out(array, up) && !state[up[0]][up[1]]) {//不出界，并且没有走过
            //表示这一步可以走
            int plus = 0;
            if (array[start[0]][start[1]] != 'v') {//如果不是这个方向就需要使用魔法
                plus = 1;
            }
            state[start[0]][start[1]] = true;//走过了
            int sum;
            if (help[up[0]][up[1]] != Integer.MIN_VALUE) {
                sum = help[up[0]][up[1]] + plus;
            } else {
                sum = conveyorBelt(array, up, end, state, help) + plus;
            }
            result = Math.min(sum, result);//获得最小的步数
            state[start[0]][start[1]] = false;//还原现场
        }
        //left
        up = next(start, LEFT);
        if (out(array, up) && !state[up[0]][up[1]]) {//不出界，并且没有走过
            //表示这一步可以走
            int plus = 0;
            if (array[start[0]][start[1]] != '<') {//如果不是这个方向就需要使用魔法
                plus = 1;
            }
            state[start[0]][start[1]] = true;//走过了
            int sum;
            if (help[up[0]][up[1]] != Integer.MIN_VALUE) {
                sum = help[up[0]][up[1]] + plus;
            } else {
                sum = conveyorBelt(array, up, end, state, help) + plus;
            }
            result = Math.min(sum, result);//获得最小的步数
            state[start[0]][start[1]] = false;//还原现场
        }
        //right
        up = next(start, RIGHT);
        if (out(array, up) && !state[up[0]][up[1]]) {//不出界，并且没有走过
            //表示这一步可以走
            int plus = 0;
            if (array[start[0]][start[1]] != '>') {//如果不是这个方向就需要使用魔法
                plus = 1;
            }
            state[start[0]][start[1]] = true;//走过了
            int sum;
            if (help[up[0]][up[1]] != Integer.MIN_VALUE) {
                sum = help[up[0]][up[1]] + plus;
            } else {
                sum = conveyorBelt(array, up, end, state, help) + plus;
            }
            result = Math.min(sum, result);//获得最小的步数
            state[start[0]][start[1]] = false;//还原现场
        }
        help[start[0]][start[1]] = Math.min(result,help[start[0]][start[1]]);
        return result;
    }

    public int[] next(int[] start, int[] dir) {
        int i = start[0] + dir[0];
        int j = start[1] + dir[1];
        return new int[]{i, j};
    }

    public boolean out(char[][] array, int[] start) {
        int x = start[0];
        int y = start[1];
        if (x >= 0 && x < array.length && y >= 0 && y < array[0].length) {
            return true;
        } else {
            return false;
        }
    }
}

