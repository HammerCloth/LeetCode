package advanced;

/**回文链表
 * @author:syx
 * @date:2021/9/4 9:49
 * @version:v1.0
 */
public class Of027 {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,2,2};
        ListNode head = new ListNode(0,null);
        ListNode index = head;
        for (int i = 0; i < array.length; i++) {
            index.next = new ListNode(array[i],null);
            index = index.next;
        }
        System.out.println(isPalindrome2(head.next));
    }
    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = slow.next;
        ListNode revStart = null;
        while(slow!=null){
            if (revStart==null){
                revStart = new ListNode(slow.val,null);
            }else{
                revStart=new ListNode(slow.val,revStart);
            }
            slow = slow.next;
        }
        while(revStart!=null){
            if (head.val!= revStart.val){
                return false;
            }else{
                head=head.next;
                revStart=revStart.next;
            }
        }
        return true;
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
    public static boolean isPalindrome2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = slow.next;
        ListNode pre = null;
        while(slow!=null){
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        ListNode revStart = pre;
        while(revStart!=null){
            if (head.val!= revStart.val){
                return false;
            }else{
                head=head.next;
                revStart=revStart.next;
            }
        }
        return true;
    }
}
