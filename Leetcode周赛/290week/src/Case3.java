import java.util.Arrays;

/**
 * @ClassName Case3
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/24 11:00
 * @Version v0.1
 **/
public class Case3 {
    public static void main(String[] args) {
        int[] ints = countRectangles(new int[][]{{1, 2}, {2, 3}, {2, 5}}, new int[][]{{2, 1}, {1, 4}});
        System.out.println(Arrays.toString(ints));
    }


    public static int[] countRectangles(int[][] rectangles, int[][] points) {
        int X = 0;
        int Y = 0;
        for (int i = 0; i < rectangles.length; i++) {
            int l = rectangles[i][0];
            int h = rectangles[i][1];
            X = Math.max(l, X);
            Y = Math.max(h, Y);
        }
        int[] res = new int[points.length];
        short[][] preSum = new short[X+1][Y+1];
        for (int i = 0; i < rectangles.length; i++) {
            int l = rectangles[i][0];
            int h = rectangles[i][1];
            for (int j = 0; j <= l; j++) {
                for (int k = 0; k <= h; k++) {
                    preSum[j][k] += 1;
                }
            }
        }
        for (int i = 0; i < preSum.length; i++) {
            System.out.println(Arrays.toString(preSum[i]));
            System.out.println();
        }
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            if (x>X||y>Y){
                res[i] = 0;
            }else {
                res[i] = preSum[x][y];
            }

        }
        return res;
    }


}
