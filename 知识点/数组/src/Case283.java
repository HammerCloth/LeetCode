import java.util.Arrays;

/**
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
 *
 * @author:syx
 * @date: 2021/7/28 9:10
 * @version:v1.0
 */
public class Case283 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,1};
        moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        if (nums.length<=1){
            return;
        }
        int times = zeroCounter(nums);
        for (int i = 0; i < times; i++) {
            int a = 0;
            int b = 1;
            while (a < nums.length - 1) {
                if (nums[a] == 0) {
                    swap(nums, a, b);
                }
                a++;
                b++;
            }
        }
    }

    public static int zeroCounter(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            }
        }
        return count;
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void moveZeroes2(int[] nums) {
        if (nums.length<=1){
            return;
        }
        int a = 0;
        while(nums[a]!=0&&a<nums.length-1){
            a++;
        }
        int b = a+1;
        while(b<nums.length){
            if (nums[b]!=0){
                swap(nums,a,b);
                a++;
                b++;
            }else{
                b++;
            }
        }
    }
}
