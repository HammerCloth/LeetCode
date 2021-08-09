import java.util.List;

/**
 * 三角形最小路径和
 *
 * @author:syx
 * @date: 2021/8/6 10:55
 * @version:v1.0
 */
public class Case120 {
    public static void main(String[] args) {

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        return triangle.get(0).get(0) + minimumTotal(triangle, 1, 0);
    }

    public int minimumTotal(List<List<Integer>> triangle, int left, int i) {
        if (left >= triangle.size()) {
            return 0;
        }
        List<Integer> list = triangle.get(left);
        int i1 = list.get(i) + minimumTotal(triangle, left + 1, i);
        int i2 = list.get(i + 1) + minimumTotal(triangle, left + 1, i + 1);
        return Math.min(i1, i2);
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int row = triangle.size() + 1;
        int col = triangle.get(triangle.size() - 1).size() + 1;
        int[][] help = new int[row][col];
        for (int i = 0; i < col; i++) {
            help[row - 1][i] = 0;
        }

        for (int j = row - 2; j > 0; j--) {
            for (int i = 0; i < triangle.get(j-1).size(); i++) {
                help[j][i] = Math.min(triangle.get(j).get(i) + help[j + 1][i], triangle.get(j).get(i + 1) + help[j + 1][i + 1]);
            }
        }
        return help[1][0] + triangle.get(0).get(0);

    }
}
