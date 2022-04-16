/**
 * @author:syx
 * @date:2021/9/30 9:50
 * @version:v1.0
 */
public class Case002 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5, null);
        ListNode l2 = new ListNode(5, null);
        addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int upTag = 0;
        ListNode indexL1 = l1;
        ListNode indexL2 = l2;
        ListNode indexPreL1 = null;
        while (indexL1 != null && indexL2 != null) {
            int sum = indexL1.val + indexL2.val + upTag;
            indexL1.val = sum % 10;
            indexL2.val = sum % 10;
            upTag = sum / 10;
            indexPreL1 = indexL1;
            indexL1 = indexL1.next;
            indexL2 = indexL2.next;
        }
        ListNode indexLast = null;
        ListNode result = null;
        if (indexL1 == null && indexL2 == null) {
            indexLast = indexPreL1;
            if (upTag != 0) {
                indexLast.next = new ListNode(upTag, null);
                return l1;
            } else {
                return l1;
            }
        } else if (indexL1 != null) {
            indexLast = indexL1;
            result = l1;
        } else {
            indexLast = indexL2;
            result = l2;
        }
        while (upTag != 0) {
            int sum = indexLast.val + upTag;
            upTag = sum / 10;
            indexLast.val = sum % 10;
            if (upTag != 0 && indexLast.next == null) {
                indexLast.next = new ListNode(0, null);
            }
            indexLast = indexLast.next;
        }

        return result;
    }

    public static class ListNode {
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
