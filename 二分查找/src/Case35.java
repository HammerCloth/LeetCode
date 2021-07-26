/**搜索插入的位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * @author:syx
 * @date:2021/7/26 20:40
 * @version:v1.0
 */
public class Case35 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        System.out.println(searchInsert(nums, 9));
    }
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        if (target>nums[nums.length-1]){
            return nums.length;
        }

        while(left<right){
            int mid = left+(right-left)/2;
            if (nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]>target){
                right = mid;
            }else{
                return mid;
            }
        }
        return left;
    }
}
