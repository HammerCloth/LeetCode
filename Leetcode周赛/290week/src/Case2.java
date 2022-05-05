import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName Case2
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/24 10:19
 * @Version v0.1
 **/
public class Case2 {
    public List<Integer> intersection(int[][] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] set = new int[100010];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                set[nums[i][j]]+=1;
                if (set[nums[i][j]]== nums.length){
                    list.add(nums[i][j]);
                }
            }
        }
        Collections.sort(list);
        return list;
    }
}
