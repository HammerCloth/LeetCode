import java.util.Arrays;

/**
 * 删除有序数组的的重复项
 * 给你一个有序数组nums，请你原地输出重复出现的元素，使得每个元素只出现一次，
 * 返回删除后数组的新长度
 * 不要使用额外的数组空间，你必须在原地修改输入数组，并在使用O（1）额外空间的条件
 * 下完成
 * @author: syx
 * @date: 2021/4/18 18:12
 * @version: v1.0
 */
public class Case26 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

    }
    public static int removeDuplicates(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return 1;
        }
        //双指针；
        int max = nums[0];
        int a = 1;//a指针永远在最大值的后面一个位置
        for (int b=1;b<nums.length;b++){
            if (nums[b]>max){
                max = nums[b];
                nums[a]=nums[b];
                a++;
            }
        }
        return a;
    }

}
