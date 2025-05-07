package com.arturfrimu.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem2AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }

    @Test
    void test() {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4, node1);
        ListNode node3 = new ListNode(3, node2);

        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6, node4);
        ListNode node6 = new ListNode(4, node5);

        ListNode listNode = addTwoNumbers(node3, node6);
        Assertions.assertEquals(7, listNode.val);
        Assertions.assertEquals(0, listNode.next.val);
        Assertions.assertEquals(8, listNode.next.next.val);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummy;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
