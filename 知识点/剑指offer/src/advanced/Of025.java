package advanced;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 链表中的两数相加
 *
 * @author:syx
 * @date: 2021/9/2 9:22
 * @version:v1.0
 */
public class Of025 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, null);
        ListNode l2 = new ListNode(9, null);
        l2.next = new ListNode(9, null);

        System.out.println(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0) {
            return l2;
        } else if (l2.val == 0) {
            return l1;
        }
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();

        while (l1 != null) {
            one.add(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            two.add(l2.val);
            l2 = l2.next;
        }

        Collections.reverse(one);
        Collections.reverse(two);

        int carry = 0;
        List<Integer> ressultList = new ArrayList<>();
        int size = Math.min(one.size(), two.size());
        int i = 0;
        for (; i < size; i++) {
            int sum = one.get(i) + two.get(i) + carry;
            if (sum < 10) {
                carry = 0;
                ressultList.add(sum);
            } else {
                carry = 1;
                sum = sum - 10;
                ressultList.add(sum);
            }
        }

        if (one.size() > i) {
            for (int j = i; j < one.size(); j++) {
                int sum = one.get(j) + carry;
                if (sum >= 10) {
                    carry = 1;
                    ressultList.add(sum - 10);
                } else {
                    carry = 0;
                    ressultList.add(sum);
                }
            }
        } else if (two.size() > i) {
            for (int j = i; j < two.size(); j++) {
                int sum = two.get(j) + carry;
                if (sum >= 10) {
                    carry = 1;
                    ressultList.add(sum - 10);
                } else {
                    carry = 0;
                    ressultList.add(sum);
                }

            }
        }

            if (carry == 1) {
                ressultList.add(1);
            }


            Collections.reverse(ressultList);

            ListNode result = new ListNode(ressultList.get(0), null);
            ListNode index = result;
            for (int j = 1; j < ressultList.size(); j++) {
                index.next = new ListNode(ressultList.get(j), null);
                index = index.next;
            }
            return result;


        }

        public void listNodeMaker (ListNode head,int value){
            if (head.val == -1) {
                head = new ListNode(value);
            } else {
                head.next = new ListNode(value);
                head = head.next;
            }
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
