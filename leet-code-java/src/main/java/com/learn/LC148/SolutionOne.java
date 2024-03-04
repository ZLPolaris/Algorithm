package com.learn.LC148;

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
    public ListNode sortList(ListNode head) {
        ListNode res = new ListNode();
        ListNode end = res;
        ListNode p = head;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        while (p != null){
            priorityQueue.offer(p);
            p = p.next;
        }
        while (!priorityQueue.isEmpty()){
            end.next = priorityQueue.poll();
            end = end.next;
        }
        end.next = null;
        return res.next;
    }
}
