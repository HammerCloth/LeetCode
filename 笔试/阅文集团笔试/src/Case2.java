/**
 * @ClassName Case2
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/8 19:35
 * @Version v0.1
 **/
public class Case2 {
    public ListNode middleNode(ListNode head) {
        // write code here
        ListNode fast = head;
        ListNode low = head;
        while (fast != null) {
            fast = fast.next.next;
            low = low.next;
        }
        return low;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
