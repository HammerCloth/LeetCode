import java.util.*;

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
        int[][] ranges = new int[5][2];
        ranges[0] = new int[]{16, 18};
        ranges[1] = new int[]{8, 40};
        ranges[2] = new int[]{12, 23};
        ranges[3] = new int[]{5, 19};
        ranges[4] = new int[]{11, 11};
//        sortArrays(ranges);
//        simplify(ranges);
//        print2D(ranges);
        isCovered(ranges,17,34);
        System.out.println(isCovered(ranges, 24, 0, 4));
        System.out.println(ranges.length);
    }

    public static void sortArrays(int[][] ranges) {
        Arrays.sort(ranges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
    }

    public static void print2D(int[][] ranges) {
        for (int i = 0; i < ranges.length; i++) {
            System.out.println(Arrays.toString(ranges[i]));
        }
    }

    public static boolean  isCovered(int[][] ranges, int left, int right) {
        sortArrays(ranges);
        simplify(ranges);
        if (ranges[0][0]>left){
            return false;
        }
        boolean result = true;
        for (int i = left; i <=right ; i++) {
            result = result&&isCovered(ranges,i,0,ranges.length-1);
            System.out.println(i+"\t"+result);
        }
        return result;
    }

    public static boolean isCovered(int[][] ranges, int number,int start,int end){
        int temp = (start+end)>>1;
        if (start == end){
            if (number>=ranges[temp][0]&&number<=ranges[temp][1]){
                return true;
            }else{
                return false;
            }
        }
        if (number>=ranges[temp][0]&&number<=ranges[temp][1]){
            return true;
        }else if(number<ranges[temp][0]){
            return isCovered(ranges, number, start, temp);
        }else{
            return isCovered(ranges, number, temp+1,end);
        }
    }

    public static void simplify(int[][] ranges){

        for (int i=0;i<ranges.length;i++){
            for (int j = i+1;j<ranges.length;j++){
                if (ranges[i][1]>=ranges[j][1]){
                    ranges[j]=ranges[i];
                }
            }
        }
        Set<int[]> set = new HashSet<>();
        for (int i = 0; i < ranges.length; i++) {
            set.add(ranges[i]);
        }
        int[][] newRanges = new int[set.size()][2];
        int s = 0;
        for (int[] k:set) {
            newRanges[s++] = k;
        }
        ranges = newRanges;
        System.out.println("_________________");
        print2D(newRanges);
    }
}
