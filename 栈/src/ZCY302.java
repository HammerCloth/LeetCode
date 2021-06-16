import java.util.Stack;

/**
 * 实现一个特殊的栈，在实现栈的基本功能上，再实现返回栈种最小元素的操作
 * @author:syx
 * @date: 2021/6/13 16:36
 * @version:v1.0
 */
public class ZCY302 {
    public static void main(String[] args) {
        SpStack spStack = new SpStack();
        spStack.push(1);
        spStack.push(1);
        spStack.push(1);

        spStack.push(11);
        spStack.push(12);
        spStack.push(13);
        spStack.push(-1);
        spStack.push(12);
        spStack.push(1111);
        spStack.pop();
        System.out.println(spStack.pop()+" "+ spStack.getMin());
        System.out.println(spStack.pop()+" "+ spStack.getMin());
        System.out.println(spStack.pop()+" "+ spStack.getMin());
        System.out.println(spStack.pop()+" "+ spStack.getMin());
        System.out.println(spStack.pop()+" "+ spStack.getMin());
        System.out.println(spStack.pop()+" "+ spStack.getMin());
        System.out.println(spStack.pop()+" "+ spStack.getMin());
        System.out.println(spStack.pop()+" "+ spStack.getMin());

    }

}

class SpStack{
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    private int min = Integer.MAX_VALUE;

    public void push(int number){
        min = Math.min(min,number);
        minStack.push(min);
        stack.push(number);
    }

    public int pop(){
        minStack.pop();
        return stack.pop();
    }

    public int getMin(){
        return minStack.peek();
    }
}
