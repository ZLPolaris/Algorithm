package com.learn.LCR78;

import java.util.PriorityQueue;

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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode end = head;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode listNode : lists) {
            if (listNode != null) {
                priorityQueue.offer(listNode);
            }
        }
        while (!priorityQueue.isEmpty()) {
            ListNode selectNode = priorityQueue.poll();
            end.next = selectNode;
            end = selectNode;
            if (selectNode.next != null) {
                priorityQueue.offer(selectNode.next);
            }
        }
        return head.next;
    }
}
