package advanced;

import java.util.HashSet;
import java.util.Set;

/**
 * @author:syx
 * @date:2021/8/31 9:46
 * @version:v1.0
 */
public class Of023 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while(headA!=null){
            set.add(headA);
            headA=headA.next;
        }
        while(headB!=null){
            if (set.contains(headB)){
                return headB;
            }
            headB=headB.next;
        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
