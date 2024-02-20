package com.learn.LC23;

import java.util.PriorityQueue;

public class SolutionOne {
}


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

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode listNode : lists) {
            if (listNode != null) {
                priorityQueue.offer(listNode);
            }
        }
        ListNode res = new ListNode();
        ListNode end = res;
        while (!priorityQueue.isEmpty()) {
            ListNode tail = priorityQueue.poll();
            end.next = tail;
            end = end.next;
            if (tail.next != null) {
                priorityQueue.offer(tail.next);
            }
        }
        return res.next;
    }
}