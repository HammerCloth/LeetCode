/**
 * 反转链表
 *
 * @author:syx
 * @date: 2021/8/4 9:18
 * @version:v1.0
 */
public class Case206 {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode result = reverseList(head.next);
        ListNode end = result;
        while(end.next!=null){
            end  = end.next;
        }
        end.next = new ListNode(head.val);
        return result;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
