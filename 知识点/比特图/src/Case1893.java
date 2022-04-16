import java.util.BitSet;

/**
 * 检查是否区域内所有整数都被覆盖
 * 给你一个二维整数数组ranges和两个整数left和right。每个ranges[i] = [starti, endi]表示一个从starti到endi的闭区间。
 * 如果闭区间[left, right]内每个整数都被ranges中至少一个区间覆盖，那么请你返回true，否则返回false。
 * 已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <= endi，那么我们称整数x被覆盖了。
 *
 * @author:syx
 * @date:2021/7/23 9:51
 * @version:v1.0
 */
public class Case1893 {
    public static void main(String[] args) {

    }

    public boolean isCovered(int[][] ranges, int left, int right) {
        BitSet bitSet = new BitSet(51);
        for (int i = 0; i < ranges.length; i++) {
            for (int j = ranges[i][0]; j <= ranges[i][1]; j++) {
                bitSet.set(j);
            }
        }
        boolean result = true;
        for (int i = left; i <= right; i++) {
            result = result && bitSet.get(i);
        }
        return result;
    }
}
