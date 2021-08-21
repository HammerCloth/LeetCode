package basic;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 包含min函数的栈
 *
 * @author:syx
 * @date:2021/8/12 19:30
 * @version:v1.0
 */
public class Of30 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(3);
        minStack.push(4);
        minStack.push(5);
        minStack.push(6);
        minStack.push(7);
        minStack.push(8);
        minStack.push(9);
        minStack.push(10);
        minStack.push(11);
        minStack.push(12);
        minStack.push(13);
        minStack.push(14);
        minStack.push(15);
        minStack.pop();
        System.out.println(minStack.min());
        System.out.println(minStack.top());

    }
}

class MinStack {
    private PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
    private int[] array;
    private int size = 0;
    private int head = 1;
    private int rail = 0;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        array = new int[10];
    }

    public void push(int x) {
        if (array.length < size * 1.3) {
            //需要扩容
            int[] newArray = new int[2*array.length];
            for (int i = 0; i < array.length; i++) {
                newArray[i]=array[i];
            }
            array=newArray;
        }
        array[head] = x;
        head = (head + 1) % array.length;
        size++;
        heap.add(x);
    }

    public void pop() {
        head = (head-1+array.length)%array.length;
        heap.remove(array[head]);
        size--;
    }

    public int top() {
        return array[(rail + size) % array.length];
    }

    public int min() {
        return heap.peek();
    }
}