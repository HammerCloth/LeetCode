package advanced;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author:syx
 * @date:2021/9/1 9:29
 * @version:v1.0
 */
public class Of024 {

    public ListNode reverseList(ListNode head) {
        ListNode result = head;
        ListNode header = head;
        List<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            header.val=list.get(i);
            header = header.next;
        }
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
