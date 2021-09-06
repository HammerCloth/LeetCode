package advanced;

/**
 * @author:syx
 * @date:2021/9/6 14:51
 * @version:v1.0
 */
public class Of029 {
    public static void main(String[] args) {
        int[] array = new int[]{1,3,5};
        Node start = new Node(1,null);
        Node head = start;
        for (int i = 0; i < array.length; i++) {
            head.next = new Node(array[i],null);
            head = head.next;
        }
        head.next = start.next;
        start = start.next;
        System.out.println(insert(start, 5));
    }
    public static Node insert(Node head, int insertVal) {
        if (head==null){
            Node first = new Node(insertVal,null);
            first.next = first;
            return first;
        }
        Node left = null;
        Node right = null;
        while(left!=head){
            if (left==null&&right==null){
                 left = head;
                 right = head.next;
            }
            // 正常情况
            if (left.val<insertVal&&right.val>insertVal){
                insert(left,right,insertVal);
                return head;
            }
            //在交界
            if (left.val<insertVal&&right.val< left.val){
                insert(left,right,insertVal);
                return head;
            }
            if (right.val< left.val&&insertVal< right.val){
                insert(left,right,insertVal);
                return head;
            }
            //相等情况
            if(insertVal== right.val||insertVal== left.val){
                insert(left,right,insertVal);
                return head;
            }
            left = right;
            right = right.next;
        }
        insert(head,head.next,insertVal);
        return head;
    }

    public static void insert(Node left,Node right, int insertVal){
        left.next = new Node(insertVal,right);
    }

    static class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}
