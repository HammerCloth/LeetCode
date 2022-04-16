import java.util.LinkedList;

import java.util.Queue;
import java.util.Stack;

/**
 * 如何用队列结构实现栈结构
 * 如何用栈结构实现队列结构
 *
 * @author:syx
 * @date: 2021/6/16 16:57
 * @version:v1.0
 */
public class ZCY303 {
    public static void main(String[] args) {
        Queue2Stack stack = new Queue2Stack();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(stack.pop());
        }
    }
}

/**
 * 使用队列结构实现栈结构
 * 使用一个缓冲栈，每次需要pop对象时，需要将队列前方的元素放入缓冲栈中，就可以实现先进后出
 */
class Queue2Stack {
    private static Queue<Integer> queue = new LinkedList<>();
    private static Queue<Integer> help = new LinkedList<>();

    public void push(int element) {
        queue.offer(element);
    }

    public int pop() {
        int times = queue.size();
        for (int i = 0; i < times - 1; i++) {
            help.offer(queue.poll());
        }
        int result = queue.poll();
        Queue<Integer> temp = queue;
        queue = help;
        help = queue;
        return result;
    }
}

/**
 * 使用栈结构来实现队列结构
 * 使用两个栈来互相倒
 */
class Stack2Queue {
    private static Stack<Integer> stackA = new Stack<>();
    private static Stack<Integer> stackB = new Stack<>();
    private static int size;

    public void offer(int element) {
        stackA.push(element);
        size++;
    }

    public int poll() {
        int times = stackA.size();
        for (int i = 0; i < times; i++) {
            stackB.push(stackA.pop());
        }
        size--;
        return stackB.pop();
    }
}
