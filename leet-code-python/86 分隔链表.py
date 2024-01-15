from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        small = ListNode(-1)
        p = small
        pt = head
        newHead = ListNode(-1, head)
        front = newHead
        while pt:
            if pt.val < x:
                front.next = pt.next
                p.next = pt
                p = p.next
                pt = pt.next
                pass
            else:
                pt = pt.next
                front = front.next
                pass
            pass
        p.next = newHead.next
        return small.next
    pass
