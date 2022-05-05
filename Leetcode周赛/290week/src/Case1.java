import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Case1
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/24 10:19
 * @Version v0.1
 **/
public class Case1 {
    public int countLatticePoints(int[][] circles) {
        Set<String> set = new HashSet<>();//用于存储点，不重复
        for (int i = 0; i < circles.length; i++) {
            int x = circles[i][0];
            int y = circles[i][1];
            int r = circles[i][2];
            for (int j = x - r; j <= x + r; j++) {//点的x
                for (int k = y - r; k <= y + r; k++) {//点的y
                    //计算长度
                    if (((j - x) * (j - x) + (k - y) * (k - y)) <= (r * r)){
                        set.add(j+"-"+k);
                    }
                }
            }
        }
        return set.size();
    }
}
