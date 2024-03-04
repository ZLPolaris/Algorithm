package com.learn.LC24;

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

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        ListNode res = new ListNode();
        res.next = head;
        ListNode end = res;
        while (second != null) {
            first.next = second.next;
            end.next = second;
            second.next = first;
            end = first;
            first = first.next;
            second = first == null ? null : first.next;
        }
        return res.next;
    }
}
