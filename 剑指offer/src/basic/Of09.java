package basic;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * @author:syx
 * @date:2021/8/12 19:17
 * @version:v1.0
 */
public class Of09 {
    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());

    }
}
class CQueue{
    private Stack<Integer> stackA = new Stack<>();
    private Stack<Integer> stackB = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        stackA.add(value);
    }

    public int deleteHead() {
        if (stackB.size()==0&&stackA.size()==0){
            return -1;
        }
        if (stackB.size()>0){
            return stackB.pop();
        }else{
            int size = stackA.size();
            for (int i = 0; i < size; i++) {
                stackB.push(stackA.pop());
            }
            return stackB.pop();
        }
    }
}
