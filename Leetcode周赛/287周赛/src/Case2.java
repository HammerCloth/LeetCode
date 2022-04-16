import java.util.*;

/**
 * @ClassName Case
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/3 10:47
 * @Version v0.1
 **/
public class Case2 {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer,Integer> win = new HashMap<>();
        HashMap<Integer,Integer> lose = new HashMap<>();
        for (int i = 0; i < matches.length; i++) {
            int winer = matches[i][0];
            int loser = matches[i][1];
            if (win.containsKey(winer)){
                win.put(winer,win.get(winer)+1);
            }else{
                win.put(winer,1);
            }
            if (lose.containsKey(loser)){
                lose.put(loser,lose.get(loser)+1);
            }else{
                lose.put(loser,1);
            }
        }
        List<Integer> a = new ArrayList<>();
        for(int w :win.keySet()){
            if (!lose.containsKey(w)){
                a.add(w);
            }
        }
        Collections.sort(a);
        List<Integer> b = new ArrayList<>();
        for (int k: lose.keySet()){
            if (lose.get(k)==1){
                b.add(k);
            }
        }
        Collections.sort(b);
        List<List<Integer>> result = new ArrayList<>();
        result.add(a);
        result.add(b);
        return result;
    }
}
