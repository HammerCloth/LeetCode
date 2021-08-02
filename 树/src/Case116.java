import java.util.Stack;

/**填充每个节点的下一个右侧节点指针
 * @author:syx
 * @date:2021/8/2 16:06
 * @version:v1.0
 */
public class Case116 {
    public static void main(String[] args) {
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node two = new Node(2,four,five,null);
        Node three = new Node(3,six,seven,null);
        Node one = new Node(1,two,three,null);

        connect(null);

    }
    public static Node connect(Node root) {
        Stack<Node> stackA = new Stack<>();
        if (root!=null){
            stackA.push(root);
        }
        while(!stackA.isEmpty()){
            Stack<Node> stackB = new Stack<>();
            Node temp = null;
            int size = stackA.size();
            for(int i=0;i<size;i++){
                Node pop = stackA.pop();
                pop.next=temp;
                temp = pop;
                if (pop.right!=null){
                    stackB.push(pop.right);
                }
                if(pop.left!=null){
                    stackB.push(pop.left);
                }
            }
            stackA.clear();
            size = stackB.size();
            for (int i = 0; i < size; i++) {
                Node pop = stackB.pop();
                stackA.push(pop);
            }
        }
        return root;
    }
    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
