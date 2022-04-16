/**
 * 在数组中找到一个局部最小的位置
 * @author:syx
 * @date: 2021/6/21 16:11
 * @version:v1.0
 */
public class ZCY409 {
    public static void main(String[] args) {
        int[] a = new int[]{6,5,4,3,4,5,7};
        System.out.println(partMin(a));
    }

    public static int partMin(int[] arr){
        if (arr[0]<arr[1]){
            return arr[0];
        }

        if (arr[arr.length-1]<arr[arr.length-2]){
            return arr[arr.length-1];
        }

        return partMin(arr,0, arr.length-1);

    }

    public static int partMin(int[] arr,int left,int right){
        int mid = right + (right-left)>>1;

        if (arr[mid]<arr[mid-1]&&arr[mid]<arr[mid+1]){
            return arr[mid];
        }else{
            if (arr[mid]>=arr[mid-1]){
                return partMin(arr,left,mid-1);
            }else{
                return partMin(arr,mid+1,right);
            }
        }

    }
}
