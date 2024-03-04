package com.learn.LC138;

import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class SolutionOne {
    public Node copyRandomList(Node head) {
        Node res = new Node(-1);
        Node end = res;
        HashMap<Node, Node> hashMap = new HashMap<>();
        hashMap.put(null, null);
        Node p = head;
        while (p != null) {
            end.next = new Node(p.val);
            hashMap.put(p, end.next);
            end = end.next;
            p = p.next;
        }
        p = head;
        Node q = res.next;
        while (p != null) {
            q.random = hashMap.get(p.random);
            p = p.next;
            q = q.next;
        }
        return res.next;
    }
}
