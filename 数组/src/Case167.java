import java.util.Arrays;

/**
 * 两数之和 II - 输入有序数组
 * 给定一个已按照 升序排列的整数数组numbers ，请你从数组中找出两个数满足相加之和等于目标数target 。
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，
 * 所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * @author:syx
 * @date: 2021/7/28 10:09
 * @version:v1.0
 */
public class Case167 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0};
        System.out.println(Arrays.toString(twoSum(nums, -1)));
    }
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        while(left<right){
            int sum = numbers[left]+numbers[right];
            if (sum==target){
                return new int[]{left+1,right+1};
            }else if(sum<target){
                left++;
            }else{
                right--;
            }
        }
        return null;
    }
}
