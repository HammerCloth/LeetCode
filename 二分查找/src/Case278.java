/**
 * 第一个错误版本
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测
 * 由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * 你可以通过调用bool isBadVersion(version)接口来判断版本号 version 是否在单元测试中出错。
 * 实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * @author:syx
 * @date: 2021/7/26 20:03
 * @version:v1.0
 */
public class Case278 {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(2));
    }
    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        if (left==right){
            return left;
        }

        while(left<=right){
            int temp = left+(right-left)/2;
            if (temp==left){
                if (isBadVersion(temp)){
                    return temp;
                }else{
                    left = temp+1;
                    continue;
                }
            }
            if(isBadVersion(temp)&&!isBadVersion(temp-1)){
                return temp;
            }else if(isBadVersion(temp)&&isBadVersion(temp-1)){
                right = temp-1;
            }else{
                left = temp+1;
            }
        }
        return 1;
    }
    public static boolean isBadVersion(int i){
        if (i>=2){
            return true;
        }else{
            return false;
        }
    }
}
