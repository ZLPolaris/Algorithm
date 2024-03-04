package com.learn.LC234;

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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode reversedNode = new ListNode();
        ListNode slow = head;
        ListNode quick = head;
        boolean flag = true;
        while (quick != null) {
            ListNode tmp = slow;
            slow = slow.next;
            quick = quick.next;
            if (quick != null) {
                quick = quick.next;
            }else {
                flag = false;
            }
            tmp.next = reversedNode.next;
            reversedNode.next = tmp;
        }
        ListNode p1 = null;
        ListNode p2 = slow;
        if (flag) {
            p1 = reversedNode.next;
        } else {
            p1 = reversedNode.next.next;
        }
        System.out.println(p1.val);
        System.out.println(p2.val);
        while (p1 != null && p1.val == p2.val) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1 == null;
    }
}
