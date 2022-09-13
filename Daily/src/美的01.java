import java.util.ArrayList;

/**
 * @ClassName 美的01
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/9/12 16:07
 * @Version v0.1
 **/
public class 美的01 {
    public static void main(String[] args) {
        String[] s = new String[]{"This", "is", "an", "instance", "of", "code", "alignment."};
        int M = 16;
        System.out.println(justifyFill(s, M));
    }

    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        // write code here
        ArrayList<Integer> one = new ArrayList<>();
        one.add(1);
        res.add(one);
        if (numRows == 1) return res;
        ArrayList<Integer> two = new ArrayList<>();
        two.add(1);
        two.add(1);
        res.add(two);
        if (numRows == 2) return res;
        int size = numRows - 2;
        ArrayList<Integer> pre = two;
        for (int i = 0; i < size; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 0; j < pre.size() - 1; j++) {
                temp.add(pre.get(j) + pre.get(j + 1));
            }
            temp.add(1);
            pre = temp;
            res.add(temp);
        }
        return res;
    }

    public static ArrayList<String> justifyFill(String[] words, int M) {
        // write code here
        //每一行都有M个字母，这些字母不是单词就是空格，空格只是在单词之间，如果空格不够分就放在左边第一个缝隙中，单词第一个一定左对齐
        //单词之间至少有一个空格，换行不需要空格
        //将每一个单词统计出来，然后统计单词size
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        for (int i = 0; i < words.length; ) {
            int size = 0;
            int k = i;
            ArrayList<String> temp = new ArrayList<>();
            while (k < words.length && size + words[k].length() <= M) {
                size += words[k].length() + 1;
                temp.add(words[k]);
                k++;
            }
            list.add(temp);
            i = k;
            //System.out.println(i);
            //System.out.println(temp);
        }
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < list.size()-1; i++) {
            ArrayList<String> temp = list.get(i);
            int size = 0;
            for (int j = 0; j < temp.size(); j++) {
                size += temp.get(j).length();
            }
            if (temp.size() == 1) {
                StringBuffer sb = new StringBuffer(temp.get(0));
                for (int j = 0; j < M-size; j++) {
                    sb.append(" ");
                }
                res.add(sb.toString());
            } else {
                StringBuffer[] sbs = new StringBuffer[temp.size()-1];
                for (int j = 0; j < sbs.length; j++) {
                    StringBuffer sb = new StringBuffer(temp.get(j));
                    sbs[j] = sb;
                }
                for (int j = 0; j < M-size; j++) {
                    int k = j%(sbs.length);
                    //System.out.println(sbs.length+" "+k);
                    sbs[k].append(" ");
                }
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < sbs.length; j++) {
                    sb.append(sbs[j]);
                }
                sb.append(temp.get(temp.size()-1));
                res.add(sb.toString());
            }
        }
        ArrayList<String> temp = list.get(list.size()-1);
        StringBuffer sb = new StringBuffer();
        int size= 0;
        for (int i = 0; i < temp.size()-1; i++) {
            sb.append(temp.get(i));
            size += temp.get(i).length();
            sb.append(" ");
            size += 1;
        }
        sb.append(temp.get(temp.size()-1));
        size += temp.get(temp.size()-1).length();
        for (int i = 0; i < M-size; i++) {
            sb.append(" ");
        }
        res.add(sb.toString());
        return res;
    }
}
