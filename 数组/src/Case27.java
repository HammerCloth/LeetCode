import java.util.Arrays;

/**
 * 移除元素
 * 给你一个数组和一个值，你需要原地移除所有数值等于该值
 * 的元素，并返回移除后数组的新长度
 * 不要使用额外的空间，你必须仅使用1的额外空间，并原地修改
 * 数组
 * 元素的顺序可以改变，你不需要考虑数组中超出新长度后面的
 * 元素
 * @author:syx
 * @date: 2021/4/19 8:54
 * @version:v1.0
 */
public class Case27 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;
        int result = removeElement(nums,val);
        System.out.println(result);
        System.out.println(Arrays.toString(nums));

    }

    /**
     * 建立指针A，标示在原地创建一个新数组，且A永远在B的后方或者与B相同
     * 建立指针B，作为一个游标，来遍历原数组。
     * 1. 初始A，B均指向数组的第一个位置
     * 2. B开始往后走，如果，如果B指向一个不等于Val的数，用B的数字覆盖A，A向前，B向前
     * 3，如果B指向一个等于Val的数，则B向前，A不动
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int a = 0;
        for (int b=0;b<nums.length;b++){
            if (nums[b]!=val){
                nums[a]=nums[b];
                a++;
            }
        }
            return a;
        }
}
