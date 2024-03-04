package com.learn.LC206;

import java.util.List;

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
    public ListNode reverseList(ListNode head) {
        ListNode res = new ListNode();
        ListNode p = head;
        while (p != null) {
            ListNode tmp = p;
            p = p.next;
            tmp.next = res.next;
            res.next = tmp;
        }
        return res.next;
    }
}
