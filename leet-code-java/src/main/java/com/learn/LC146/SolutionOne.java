package com.learn.LC146;

import java.util.LinkedList;

public class SolutionOne {
}

class Pair {
    public Integer key;
    public Integer value;
    public Pair next;

    public Pair() {
    }

    public Pair(Integer key, Integer value, Pair next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}

class LRUCache {
    private final Pair head = new Pair(-1, -1, null);
    private Pair tail = head;
    private final Integer capacity;
    private Integer count = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    private Pair getPair(int key) {
        Pair p = this.head;
        while (p.next != null && p.next.key != key) {
            p = p.next;
        }
        return p;
    }

    public void look() {
        Pair ps = head;
        while (ps != null) {
            System.out.printf("key:%d, value:%d\n", ps.key, ps.value);
            ps = ps.next;
        }
        System.out.println("---------------");
    }

    public int get(int key) {
        Pair p = this.getPair(key);
        if (p.next != null) {
            Pair tmp = p.next;
            p.next = p.next.next;
            if (tmp == tail) {
                tail = p;
            }
            tail.next = tmp;
            tail = tail.next;
            tail.next = null;
            return tail.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Pair p = this.getPair(key);
        System.out.println(p.value);
        if (p.next != null) {
            Pair tmp = p.next;
            p.next = p.next.next;
            if (tmp == tail) {
                tail = p;
            }
            tail.next = tmp;
            tmp.value = value;
        } else {
            if (count >= capacity) {
                head.next = head.next.next;
                if (head.next == null) {
                    tail = head;
                }
                count--;
            }
            tail.next = new Pair(key, value, null);
            count++;
        }
        tail = tail.next;
        tail.next = null;
    }

//    public static void main(String[] args) {
//        LRUCache lruCache = new LRUCache(2);
//        lruCache.get(2);
//        lruCache.look();
//        lruCache.put(2,6);
//         lruCache.look();
//         lruCache.get(1);
//         lruCache.look();
//         lruCache.put(1,5);
//         lruCache.look();
//         lruCache.put(1,2);
//         lruCache.look();
//    }
}
