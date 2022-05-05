import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Case2
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/5/1 10:11
 * @Version v0.1
 **/
public class Case2 {
    public static void main(String[] args) {
        System.out.println(minimumCardPickup(new int[]{1,11,0,11,1}));
        System.out.println(minimumCardPickup(new int[]{3,4,2,3,4,7}));
        System.out.println(minimumCardPickup(new int[]{}));

    }

    public static int minimumCardPickup(int[] cards) {
        int left = 0;
        int right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = Integer.MAX_VALUE;
        while (left < cards.length && right < cards.length) {
            if (map.containsKey(cards[right])) {
                map.put(cards[right], map.get(cards[right]) + 1);
                if (map.get(cards[right]) == 2) {//存在一对
                    while (cards[left] != cards[right]) {
                        map.remove(cards[left]);//去掉
                        left++;
                    }
                    count = Math.min(count, right - left + 1);
                    map.put(cards[right],1);
                    left++;
                }
            } else {
                map.put(cards[right], 1);
            }
            right++;
        }
        if (count == Integer.MAX_VALUE) return -1;
        return count;
    }
}
