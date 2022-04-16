package advanced;

import java.util.*;

/**
 * 数组中和为0的三个数
 *
 * @author:syx
 * @date: 2021/8/11 9:41
 * @version:v1.0
 */
public class Of007 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 0, -2, -1, 1, 2};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Map<Integer, Integer> all = new HashMap<>();
        Set<Integer> positive = new HashSet<>();
        Set<Integer> negative = new HashSet<>();
        Set<List<Integer>> result = new HashSet<>();

        for (int i : nums) {
            if (all.containsKey(i)) {
                all.put(i, all.get(i) + 1);
            } else {
                all.put(i, 1);
            }
            if (i > 0) {
                positive.add(i);
            } else if (i < 0) {
                negative.add(i);
            }
        }

        for (int i : positive) {
            for (int j : negative) {
                if (all.containsKey(-j - i)) {
                    if ((-j - i) != j && (-j - i) != i) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(i);
                        temp.add(j);
                        temp.add(-i - j);
                        Collections.sort(temp);
                        result.add(temp);
                    } else if (all.get(-j - i) > 1) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(i);
                        temp.add(j);
                        temp.add(-i - j);
                        Collections.sort(temp);
                        result.add(temp);
                    }
                }
            }
        }
        if (all.containsKey(0) && all.get(0) >= 3) {
            List<Integer> temp = new ArrayList<>();
            temp.add(0);
            temp.add(0);
            temp.add(0);
            result.add(temp);
        }
        List<List<Integer>> back = new ArrayList<>(result);
        return back;
    }
}
