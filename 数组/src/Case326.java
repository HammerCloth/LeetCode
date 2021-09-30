/**
 * 3的幂
 *
 * @author:syx
 * @date:2021/9/24 9:51
 * @version:v1.0
 */
public class Case326 {
    private static final int[] help = new int[]{
            1,
            3,
            9,
            27,
            81,
            243,
            729,
            2187,
            6561,
            19683,
            59049,
            177147,
            531441,
            1594323,
            4782969,
            14348907,
            43046721,
            129140163,
            387420489,
            1162261467
    };

    public static void main(String[] args) {
        for (int i:help){
            System.out.println(i+""+isPowerOfThree(i));
        }
    }

    public static boolean isPowerOfThree(int n) {
        return binarySearch(n);
    }

    public static boolean binarySearch(int n) {
        int left = 0;
        int right = help.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (help[mid] == n) {
                return true;
            } else if (help[mid] < n) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return false;
    }

}
