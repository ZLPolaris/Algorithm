package com.learn.LC23;


import java.util.PriorityQueue;

//力扣热题100复习
public class SolutionThree {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode listNode : lists) {
            if(listNode != null){
                priorityQueue.offer(listNode);
            }
        }
        ListNode res = new ListNode();
        ListNode end = res;
        while (!priorityQueue.isEmpty()){
            ListNode peek = priorityQueue.poll();
            if(peek.next != null){
                priorityQueue.offer(peek.next);
            }
            end.next = peek;
            end = end.next;
        }
        return res.next;
    }
}
