# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        pA = headA
        pB = headB
        while pA is not pB:
            pA = pA.next
            pB = pB.next
            if not pA:
                pA = headB
                pass
            if not pB:
                pB = headA
                pass
            print(pA is not pB)
            print(pA.val, pB.val)
        return pA

    pass
