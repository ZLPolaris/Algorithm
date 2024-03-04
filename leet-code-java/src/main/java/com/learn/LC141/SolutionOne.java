package com.learn.LC141;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class SolutionOne {
    public boolean hasCycle(ListNode head) {
        if(head == null ||  head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode quick = head;
        while (quick != null) {
            slow = slow.next;
            quick = quick.next;
            if (quick != null) {
                quick = quick.next;
            }
            if(quick == slow){
                return true;
            }
        }
        return false;
    }
}
