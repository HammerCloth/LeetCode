/**
 * @ClassName Case7
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/20 09:25
 * @Version v0.1
 **/
public class Case7 {
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

    public int getK(ListNode head,int k){
        ListNode listNode = sortList(head);
        for (int i = 1; i < k; i++) {
            listNode = listNode.next;
        }
        return listNode.val;

    }
    public ListNode sortList(ListNode head) {
        //排除head直接为空的特殊情况
        if (head == null) {
            return head;
        }
        //获得链表的长度
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        ListNode dummyHead = new ListNode(0, head);
        //开始自底向上归并排序
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            //prev用于保存已经排序后的链表
            ListNode prev = dummyHead, curr = dummyHead.next;
            while (curr != null) {
                //获得长度为sublength的第一个链表
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                //获得长度为sublength的第二链表的头节点
                ListNode head2 = curr.next;
                //将第一个链表的尾节点变为null
                curr.next = null;
                //将curr指向第二个链表的头节点
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                //用next来保存剩下的链表，并且把第二个链表的尾部变为null
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                //获得两个链表归并后的链表
                ListNode merged = merge(head1, head2);
                //用prev保存
                prev.next = merged;
                //将prev移动到prev的末端
                while (prev.next != null) {
                    prev = prev.next;
                }
                //将curr指向后面的链表
                curr = next;
            }
        }
        return dummyHead.next;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }

}
