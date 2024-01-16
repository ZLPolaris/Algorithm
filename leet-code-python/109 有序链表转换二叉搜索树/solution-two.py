# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    pt = None

    def sortedListToBST(self, head: Optional[ListNode]) -> Optional[TreeNode]:
        count = 0
        p = head
        while p:
            count += 1
            p = p.next
            pass
        self.pt = head

        def buildSortedListToBST(left: int, right: int) -> Optional[TreeNode]:
            if left > right:
                return None
            mid = left + (right - left) // 2
            node = TreeNode()
            node.left = buildSortedListToBST(left, mid - 1)
            node.val = self.pt.val
            self.pt = self.pt.next
            node.right = buildSortedListToBST(mid + 1, right)
            return node

        return buildSortedListToBST(0, count - 1)
