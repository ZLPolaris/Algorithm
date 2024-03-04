package com.learn.LC19;

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode quick = head;
        int count = 0;
        while (quick != null) {
            quick = quick.next;
            if (count > n) {
                slow = slow.next;
            }
            count++;
        }
        if(count <= n){
            return head.next;
        }else {
            slow.next = slow.next.next;
            return head;
        }
    }
}
