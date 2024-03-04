package com.learn.LC21;

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode tail = res;
        while (list1 != null && list2 != null){
            if(list1.val <= list2.val){
                tail.next = list1;
                tail = tail.next;
                list1 = list1.next;
            }else {
                tail.next = list2;
                tail = tail.next;
                list2 = list2.next;
            }
        }
        tail.next = list1 != null ? list1 : list2;
        return res.next;
    }
}
