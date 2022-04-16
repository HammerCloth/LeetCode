/**
 * 折纸问题
 * 请把一段纸条竖着放在桌子上，然后从纸条的上方对折一次，压出折痕后展开。此时
 * 折痕是凹下去的，即折痕突起的方向指向纸条的背面。如果从纸条的下边向上方连续对折2
 * 次，压出折痕后展开，此时有三条折痕，。给定一个参数n，代表纸条都从下边向上方对折N次
 * 请从上到下打印所有放向。
 * @author:syx
 * @date: 2021/6/18 17:02
 * @version:v1.0
 */
public class ZCY404 {
    public static void main(String[] args) {
        paperFloding(7,false);
    }

    public static void paperFloding(int n,boolean flag){
        if (n<=0){
            return;
        }
        paperFloding(n-1,true);
        System.out.println(flag?"上":"下");
        paperFloding(n-1,false);
    }
}
