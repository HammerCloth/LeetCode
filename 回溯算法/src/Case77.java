import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 组合
 *
 * @author:syx
 * @date:2021/8/5 11:04
 * @version:v1.0
 */
public class Case77 {
    public static void main(String[] args) {
        List<List<Integer>> combine = combine(1,1 );
        combine.forEach(System.out::println);
    }
    public static List<List<Integer>> combine(int n, int k) {
        if (k>n||n<1||k<=0){
            return new ArrayList<List<Integer>>();
        }
        if (n==k){
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            for (int i=1;i<=n;i++){
                temp.add(i);
            }
            result.add(temp);
            return result;
        }
        if (k==1){
            List<List<Integer>> result = new ArrayList<>();
            for (int i=1;i<=n;i++){
                ArrayList<Integer> integers = new ArrayList<>();
                integers.add(i);
                result.add(integers);
            }
            return result;
        }
        List<List<Integer>> temp1 = combine(n-1,k-1);
        temp1.forEach((o1)->o1.add(n));
        List<List<Integer>> temp2 = combine(n-1,k);
        List<List<Integer>> result = new ArrayList<>();
        result.addAll(temp2);
        result.addAll(temp1);
        return result;
    }
}
