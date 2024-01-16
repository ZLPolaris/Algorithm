from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        count = 0
        quickPointer = head
        slowPointer = head
        while quickPointer:
            quickPointer = quickPointer.next
            if count <= n:
                count += 1
                pass
            else:
                slowPointer = slowPointer.next
                pass
            pass
        if count <= n:
            return head.next
        else:
            slowPointer.next = slowPointer.next.next
        return head
    pass
