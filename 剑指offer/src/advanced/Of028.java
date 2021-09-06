package advanced;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author:syx
 * @date:2021/9/5 18:54
 * @version:v1.0
 */
public class Of028 {
    public Node flatten(Node head) {
        //广度优先遍历
        //将第一层的节点放入队列中
        Queue<Node> queue = new LinkedList<>();
        while (head != null) {
            queue.offer(head);
            head = head.child;
        }
        Node result1 = new Node();
        Node result = result1;
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            Node next = temp.next;
            // 将temp挂在result上
            temp.child = null;
            result.next = temp;
            temp.prev = result;
            result = result.next;
            // 压入队列中
            while (next != null) {
                queue.offer(next);
                next = next.child;
            }
        }
        result1 = result1.next;
        result1.prev = null;
        return result1;
    }
    public Node flatten2(Node head) {
        if (head==null){
            return null;
        }
        //深度优先遍历
        //将第一层的节点放入栈中
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        Node result1 = new Node();
        Node result = result1;
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            if (temp.next!=null){
                stack.push(temp.next);
            }
            if (temp.child!=null){
                stack.push(temp.child);
            }
            // 将temp挂在result上
            temp.child = null;
            result.next = temp;
            temp.prev = result;
            result = result.next;
        }
        result1 = result1.next;
        result1.prev = null;
        return result1;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}

