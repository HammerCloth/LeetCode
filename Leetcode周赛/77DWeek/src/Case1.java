/**
 * @ClassName Case1
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/30 22:17
 * @Version v0.1
 **/
public class Case1 {
    public int countPrefixes(String[] words, String s) {
        int count = 0;
        for(int i=0;i< words.length;i++){
            //数目问题
            //确认是前缀
            boolean check = check(words[i], s);
            if (check) count++;
        }
        return count;
    }
    public boolean check(String word,String s){
        if (word.length()>s.length()) return false;
        if (word.length()==s.length()) return word.equals(s);
        char[] A = word.toCharArray();
        char[] B = s.toCharArray();
        for (int i = 0; i < A.length; i++) {
            if (A[i]!=B[i]) return false;
        }
        return true;
    }
}
