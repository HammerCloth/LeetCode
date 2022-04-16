package advanced;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:syx
 * @date: 2021/9/18 11:26
 * @version:v1.0
 */
public class Of042 {

}

class RecentCounter {
    private List<Integer> list;

    public RecentCounter() {
        this.list = new ArrayList<>();
    }

    public int ping(int t) {
        int index = list.size()-1;
        int result = 1;
        while(index>=0&&list.get(index)>=t-3000){
            result++;
            index--;
        }
        list.add(t);
        return result;
    }
}