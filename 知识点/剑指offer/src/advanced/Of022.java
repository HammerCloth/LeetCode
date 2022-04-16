package advanced;

import java.util.HashSet;

/**
 * 链表中环的入口节点
 *
 * @author:syx
 * @date: 2021/8/30 10:29
 * @version:v1.0
 */
public class Of022 {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while(head!=null&&!set.contains(head)){
            set.add(head);
            head=head.next;
        }
        return head;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
