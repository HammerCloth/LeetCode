package basic;

/**
 * 从尾到头打印链表
 *
 * @author:syx
 * @date:2021/8/15 15:19
 * @version:v1.0
 */
public class Of06 {
    public int[] reversePrint(ListNode head) {
        int size = 0;
        ListNode head2 = head;
        while(head2!=null){
            size++;
            head2 = head2.next;
        }
        int[] result = new int[size];
        while(head!=null){
            result[--size] = head.val;
            head = head.next;
        }
        return result;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
