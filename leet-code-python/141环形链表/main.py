# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        quictPointer = head
        slowPointer = head
        while quictPointer:
            quictPointer = quictPointer.next
            if quictPointer:
                quictPointer = quictPointer.next
                pass
            if slowPointer == quictPointer:
                return True
                pass
            slowPointer = slowPointer.next
        return quictPointer
