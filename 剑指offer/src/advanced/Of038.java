package advanced;

import java.util.Arrays;

/**
 * 每日温度
 *
 * @author:syx
 * @date: 2021/9/15 15:32
 * @version:v1.0
 */
public class Of038 {
    public static void main(String[] args) {
        int[] temperatures = new int[]{75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        //双指针
        //直接在原数组上修改并返回
        for (int left = 0; left <= temperatures.length - 1; left++) {
            int right = left;
            while(right<temperatures.length){
                if (temperatures[right]>temperatures[left]){
                    break;
                }else{
                    right++;
                }
            }
            if (right==temperatures.length){
                temperatures[left]=0;
            }else{
                temperatures[left]=right-left;
            }
        }
        return temperatures;
    }
}
