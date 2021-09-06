package advanced;

import java.util.List;

/**
 * 删除链表的倒数第n个节点
 *
 * @author:syx
 * @date: 2021/8/29 10:02
 * @version:v1.0
 */
public class Of021 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null&&n==1){
            return null;
        }
        ListNode preLeft = head;
        ListNode left = head;
        ListNode right = head;
        for (int i = 0; i <n-1; i++) {
            right = right.next;
        }
        while(right.next!=null){
            right = right.next;
            preLeft = left;
            left = left.next;
        }
        if (left==head){
            head = head.next;
        }
        preLeft.next = left.next;
        return head;
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
