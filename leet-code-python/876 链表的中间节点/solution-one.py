from typing import Optional


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        quick = head.next
        slow = head
        while quick:
            slow = slow.next
            quick = quick.next
            if quick:
                quick = quick.next
                pass
            pass
        return slow
