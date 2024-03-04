package com.learn.LC2;

class ListNode {
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

public class SolutionOne {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode tail = null;
        int carryBit = 0;
        while (p1 != null && p2 != null) {
            int sum = p1.val + p2.val + carryBit;
            carryBit = sum / 10;
            p1.val = sum % 10;
            if (p1.next == null) {
                tail = p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        ListNode p3 = p1 != null ? p1 : p2;
        if (tail == null) {
            tail = p3;
        } else {
            tail.next = p3;
        }
        while (p3 != null) {
            int sum = p3.val + carryBit;
            carryBit = sum / 10;
            p3.val = sum % 10;
            if (p3.next == null) {
                tail = p3;
            }
            p3 = p3.next;
        }
        if (carryBit != 0) {
            tail.next = new ListNode(carryBit);
        }
        return l1 != null ? l1 : l2;
    }
}
