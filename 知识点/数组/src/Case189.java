import java.util.Arrays;

/**旋转数组
 * 给定一个数组，将数组中的元素向右移动k个位置，其中k是非负数
 * @author:syx
 * @date: 2021/7/27 9:53
 * @version:v1.0
 */
public class Case189 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        rotate(nums,3);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        if(nums.length<=1||k==0){
            return;
        }
        rotate(nums,0,k);
    }

    public static void rotate(int[] nums,int start,int k){
        if (k>=nums.length-start){
            k = k%(nums.length-start);
        }
        if(nums.length-start<=1||k==0){
            return;
        }
        int pivot = nums.length-k;
        for (int i=0;i<k;i++){
            swap(nums,start++,pivot++);
        }
        rotate(nums,start,k);
    }

    public static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
