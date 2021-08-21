package advanced;

/**
 * @author:syx
 * @date:2021/8/10 10:10
 * @version:v1.0
 */
public class Of006 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        int[] result = new int[2];
        while(left<right){
            if (numbers[left]+numbers[right]==target){
                result[1]=right;
                result[0]=left;
                return result;
            }else if(numbers[left]+numbers[right]<target){
                left++;
            }else{
                right--;
            }
        }
        return result;
    }
}
