package com.learn.LC23;

import java.util.List;

public class SolutionTwo {
}

class Solutions {
    public ListNode mergeKLists(ListNode[] lists) {
        return this.merge(lists,0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return lists[left];
        }
        int mid = (left + right) >> 1;
        return this.mergeTwoList(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

    private ListNode mergeTwoList(ListNode one, ListNode two) {
        if (one == null) {
            return two;
        }
        if (two == null) {
            return one;
        }
        ListNode end = new ListNode();
        ListNode head = end;
        ListNode p1 = one, p2 = two;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                end.next = p1;
                end = p1;
                p1 = p1.next;
            } else {
                end.next = p2;
                end = p2;
                p2 = p2.next;
            }
        }
        end.next = p1 == null ? p2 : p1;
        return head.next;
    }
}
