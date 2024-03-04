package com.learn.LC142;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class SolutionOne {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode quick = head;
        while (quick != null) {
            slow = slow.next;
            quick = quick.next;
            if (quick != null) {
                quick = quick.next;
            }
            if (quick == slow) {
                break;
            }
        }
        if (quick == null) {
            return null;
        } else {
            slow = head;
            while (quick != slow) {
                quick = quick.next;
                slow = slow.next;
            }
            return quick;
        }
    }
}
