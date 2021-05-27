import java.util.ArrayList;
import java.util.List;

/**
 * 反转每对括号间的字符串
 * 给出一个字符串s（仅含有小写英文字母和括号）。
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * 注意，您的结果中不应包含任何括号
 *
 * @author:syx
 * @date: 2021/5/26 19:15
 * @version:v1.0
 */
public class Case1190 {
    public static void main(String[] args) {
        String test = "a(bcdefghijkl(mno)p)q";
        String s = reverseParentheses(test);
        System.out.println(s);
    }
    public static String reverseParentheses(String s) {
        StringBuilder builder = new StringBuilder();
        StrStack stack = new StrStack();
        //1.按照顺序将s压入栈中
        for(int i=0;i<s.length();i++){
            String temp = s.substring(i,i+1);
            if (temp.equals(")")){
                //2.发现第一个）后开始逐个弹出
                String aStr;
                while(!(aStr=stack.pop()).equals("(")){
                    builder.append(aStr);
                }
                //3.直到弹出一个（，将弹出后组合好的队列重新压入栈中
                for(int k=0;k<builder.toString().length();k++){
                    stack.push(builder.toString().substring(k,k+1));
                }
                builder.replace(0, builder.length(), "");
            }else{
                stack.push(temp);
            }
            //4.当s全部压入后，退出
        }
        return stack.toString();
    }

}

/**
 * 建立一个字符串栈（先进后出）
 */
class StrStack{
    private List<String> list = new ArrayList<>();
    /**
     * 将一个元素压入栈中
     * @param str
     */
    void push(String str){
        list.add(str);
        System.out.println(str+"压入栈中");
        System.out.println(this.toString());

    }

    /**
     * 弹出栈中的第一个元素
     * @return 栈中的第一个元素
     */
    String pop(){
        String str = list.get(list.size()-1);
        list.remove(list.size()-1);
        System.out.println("弹出栈中的"+str);
        System.out.println(this.toString());
        return str;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i=0;i< list.size();i++){
            builder.append(list.get(i));
        }
        return builder.toString();
    }
}
