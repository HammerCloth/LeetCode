import java.util.Stack;

/**
 * 二叉树先序，中序，后序遍历的非递归实现
 * 二叉树先序，中序，后序遍历的递归实现
 *
 * @author:syx
 * @date: 2021/6/20 15:54
 * @version:v1.0
 */
public class ZCY405 {
    public static void main(String[] args) {
        Node node = new Node(0);
        node.leftNode = new Node(1);
        node.rightNode = new Node(2);
        node.leftNode.leftNode = new Node(3);
        node.leftNode.rightNode = new Node(4);
        node.rightNode.leftNode = new Node(5);
        preOrderRecur(node);
        System.out.println();
        preOrder(node);
        System.out.println();
        inOrderRecur(node);
        System.out.println();
        inOrder(node);
        System.out.println();
        posOrderRecur(node);
        System.out.println();
        posOrder(node);
        System.out.println();
    }

    public static void preOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + "\t");
        preOrderRecur(head.leftNode);
        preOrderRecur(head.rightNode);
    }

    public static void inOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.leftNode);
        System.out.print(head.value + "\t");
        inOrderRecur(head.rightNode);
    }

    public static void posOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        posOrderRecur(head.leftNode);
        posOrderRecur(head.rightNode);
        System.out.print(head.value + "\t");
    }


    public static void preOrder(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            System.out.print(temp.value + "\t");
            if (temp.rightNode != null) {
                stack.push(temp.rightNode);
            }
            if (temp.leftNode != null) {
                stack.push(temp.leftNode);
            }
        }
    }

    public static void inOrder(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.leftNode;
            } else {
                head = stack.pop();
                System.out.print(head.value + "\t");
                head = head.rightNode;
            }
        }

    }

    public static void posOrder(Node head) {
        if (head==null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Stack<Node> printStack = new Stack<>();
        stack.push(head);
        while(!stack.isEmpty()){
            Node temp = stack.pop();
            printStack.push(temp);
            if (temp.leftNode!=null){
                stack.push(temp.leftNode);
            }
            if (temp.rightNode!=null){
                stack.push(temp.rightNode);
            }
        }
        while(!printStack.isEmpty()){
            System.out.print(printStack.pop().value+"\t");
        }
    }
}
