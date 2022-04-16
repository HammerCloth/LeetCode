/**
 * 合并两个有序链表
 * @author:syx
 * @date: 2021/8/4 8:58
 * @version:v1.0
 */
public class Case21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode start = null;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                if (result == null) {
                    result = new ListNode(l2.val);
                    start = result;
                } else {
                    result.next = new ListNode(l2.val);
                    result = result.next;
                }
                l2 = l2.next;
            } else {
                if (result == null) {
                    result = new ListNode(l1.val);
                    start = result;
                } else {
                    result.next = new ListNode(l1.val);
                    result = result.next;
                }
                l1 = l1.next;
            }
        }
        if (l1 != null && result != null) {
            result.next = l1;
        } else if (l2 != null && result != null) {
            result.next = l2;
        } else if (l1 != null && result == null) {
            return l1;
        } else if (l2 != null && result == null) {
            return l2;
        }
        return start;
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
