package com.learn.LC25;

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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode p = head;
        int count = 1;
        while (p.next != null && count < k) {
            p = p.next;
            count++;
        }
        if (count < k) {
            return head;
        }
        p.next = this.reverseKGroup(p.next, k);
        ListNode res = new ListNode();
        ListNode q = head;
        while (q != p) {
            ListNode tmp = q.next;
            q.next = res.next;
            res.next = q;
            q = tmp;
        }
        ListNode tmps = q.next;
        q.next = res.next;
        res.next = q;
        head.next = tmps;
        return res.next;
    }
}
