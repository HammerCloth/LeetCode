package advanced;

import java.util.Stack;

/** 后缀表达式
 * @author:syx
 * @date: 2021/9/13 9:35
 * @version:v1.0
 */
public class Of36 {
    public static void main(String[] args) {
        String[] tokens = new String[]{"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));
    }
    public static int evalRPN(String[] tokens) {
        if (tokens.length==1){
            return Integer.parseInt(tokens[0]);
        }
        Stack<Integer> stack = new Stack();
        for(String str:tokens){
            if (str.equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                int result = a+b;
                stack.push(result);
            }else if (str.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                int result = b-a;
                stack.push(result);
            }else if (str.equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                int result = a*b;
                stack.push(result);

            }else if (str.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                int result = b/a;
                stack.push(result);
            }else{
                int i = Integer.parseInt(str);
                stack.push(i);
            } 
        }
        return stack.pop();
    }
}
