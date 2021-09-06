package advanced;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:syx
 * @date:2021/9/3 10:46
 * @version:v1.0
 */
public class Of026 {
    public void reorderList(ListNode head) {
        ListNode temp = head;
        List<Integer> list = new ArrayList<>();
        while(temp!=null){
            list.add(temp.val);
            temp = temp.next;
        }
        temp = head;
        int right = list.size()-1;
        int left = 0;
        while(left<right){
            temp.val = list.get(left);
            temp = temp.next;
            temp.val = list.get(right);
            temp = temp.next;
            left++;
            right--;
        }
        // todo 判断尾巴
        if (left==right&&temp!=null){
            temp.val = list.get(left);
        }
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
