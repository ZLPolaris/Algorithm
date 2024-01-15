# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return head
        slow = head
        quick = head.next
        res = ListNode()
        p = res
        while quick:
            if quick.val == slow.val:
                quick = quick.next
                pass
            else:
                if id(quick) == id(slow.next):
                    p.next = slow
                    p = p.next
                    pass
                slow = quick
                quick = quick.next
                pass
            pass
        if not slow.next:
            p.next = slow
            p = p.next
        p.next = None
        return res.next

    pass

