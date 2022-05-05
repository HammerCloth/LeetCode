import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Case1832
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/5/4 12:08
 * @Version v0.1
 **/
public class Case1832 {
    public static void main(String[] args) {
        findTheWinner(5,2);
    }
    /**
     *
     * @param n 总共有n个小孩
     * @param k 每次从开始算，走第个人
     * @return
     */
    public static int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            list.add(i);
        }
        int temp = 0;//从第一名小朋友开始
        while(list.size()!=1){
            temp = (temp+k-1+list.size())% list.size();
            System.out.println(temp);
            if (temp == list.size()-1){//表示属于在最末位，需要特殊处理
                list.remove(temp);
                temp = 0;
            }else{
                list.remove(temp);
            }
        }
        return list.get(0);
    }
}
