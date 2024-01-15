from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def sortedListToBST(self, head: Optional[ListNode]) -> Optional[TreeNode]:
        nums = []
        while head:
            nums.append(head.val)
            head = head.next
            pass

        def buildSortedListToBST(left, right) -> Optional[TreeNode]:
            if left > right:
                return None
            mid = left + (right - left) // 2
            return TreeNode(nums[mid], buildSortedListToBST(left, mid - 1), buildSortedListToBST(mid + 1, right))

        return buildSortedListToBST(0, len(nums) - 1)
