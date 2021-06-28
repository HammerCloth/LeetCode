import java.util.concurrent.LinkedTransferQueue;

/**
 * 给定一个数组代表一个容器，
 * 比如[3,1,2,4]
 * 所有直方图的底部都在一条水平线上，且紧靠着
 * 把这个图想象成一个容器，这个容器可以装3格水
 * 给定一个没有负数的数组arr，返回能装几格水
 *
 * @author:syx
 * @date:2021/6/27 16:39
 * @version:v1.0
 */
public class ZCY801 {

    public static void main(String[] args) {
        int[] arr = new int[]{5,4,1,4,5};
        System.out.println(saveWater2(arr));
    }

    public static int saveWater1(int[] arr) {

        int Max = arr[0];
        int[] preMax = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            Max = Math.max(arr[i], Max);
            preMax[i] = Max;
        }
        Max = arr[arr.length - 1];
        int[] posMax = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            Max = Math.max(arr[i], Max);
            posMax[i] = Max;
        }
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= posMax[i] || arr[i] >= preMax[i]) {

            } else {
                int water = Math.min(posMax[i], preMax[i]) - arr[i];
                result += water;
            }
        }
        return result;

    }

    public static int saveWater2(int[] arr){
        int result = 0;
        int preMax = arr[0];
        int posMax = arr[arr.length-1];
        int left = 1;
        int right = arr.length-2;
        while(left<=right){
            if (preMax<posMax){
                if (arr[left]<preMax){
                    result+=(preMax-arr[left]);
                }else{
                    preMax = arr[left];
                }
                left++;
            }else{
                if ( arr[right]<posMax){
                    result+=(posMax-arr[right]);
                }else{
                    posMax = arr[right];
                }
                right--;
            }
        }
        return result;
    }

}
